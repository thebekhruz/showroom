package uz.schoolrank.schoolrank.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.schoolrank.schoolrank.component.MessageService;
import uz.schoolrank.schoolrank.entity.SmsCode;
import uz.schoolrank.schoolrank.entity.User;
import uz.schoolrank.schoolrank.enums.RoleName;
import uz.schoolrank.schoolrank.exceptions.RestException;
import uz.schoolrank.schoolrank.payload.*;
import uz.schoolrank.schoolrank.repository.AttachmentRepository;
import uz.schoolrank.schoolrank.repository.RoleRepository;
import uz.schoolrank.schoolrank.repository.SmsCodeRepository;
import uz.schoolrank.schoolrank.repository.UserRepository;
import uz.schoolrank.schoolrank.secret.JwtProvider;
import uz.schoolrank.schoolrank.service.abs.AuthService;
import uz.schoolrank.schoolrank.service.abs.SmsCodeService;
import uz.schoolrank.schoolrank.utills.constants.Message;
import uz.schoolrank.schoolrank.utills.constants.Rest;

import java.sql.Timestamp;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService, UserDetailsService {
    private final UserRepository userRepository;
    private final SmsCodeRepository smsCodeRepository;
    private final AuthenticationManager authenticateManager;
    private final JwtProvider jwtProvider;
    private final MainService mainService;
    private final SmsCodeService smsCodeService;
    private final AttachmentRepository attachmentRepository;
    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findFirstByEmailAndEnabledIsTrueAndAccountNonExpiredIsTrueAndCredentialsNonExpiredIsTrueAndAccountNonLockedIsTrue(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }


    //EMAIL VA PAROL ORQALI LOGIN BO'LISH
    @Override
    public ApiResult<TokenDTO> signIn(SignInDTO signInDTO) {
        //AGAE BUNDAY EMAIL TOPILMASA THROW QILAMIZ
        emailIfNotFoundThrow(signInDTO.getEmail());

        User currentUser = checkPhoneNumberAndPasswordAndEtcAndSetAuthenticationOrThrow(signInDTO.getEmail(), signInDTO.getPassword());
        TokenDTO tokenDTO = generateToken(currentUser);
        return ApiResult.success(tokenDTO);
    }


    @Override
    public ApiResult<String> signUp(SignUpDTO signUpDTO) {
        mainService.checkPasswordEqualityIfErrorThrow(signUpDTO.getPassword(), signUpDTO.getPrePassword());

        //AGAR TANLANGAN ROLE ADMIN BOLSA THROW QILAMIZ
        ifRoleAdminThrow(signUpDTO);
        //USER OLDIN ROYHATDAN OTGAN BOLSA THROW
        emailIfExistsThrow(signUpDTO.getEmail());

        String code = mainService.generateVerificationCode(Rest.CODE_COUNT);

        //DATABASEGA HALI TASDIQLANMAGAN USERNI SAQLASH, DATABASEDA BO'LSA SAQLAMAYDI
        saveNotVerifiedUser(signUpDTO);

        SmsCode smsCode = SmsCode.builder().code(code).email(signUpDTO.getEmail()).checked(false).build();

        //MIJOZNING EMAILIGA CODE YUBORISH
        smsCodeService.send(signUpDTO.getEmail(), code);

        smsCodeRepository.save(smsCode);
        return ApiResult.success(Message.SMS_CODE_SUCCESSFULLY_SEND);
    }

    @Override
    public ApiResult<TokenDTO> verify(SmsCodeDTO smsCodeDTO) {
        Optional<SmsCode> optionalSmsCode = smsCodeRepository.findFirstByEmailAndCodeAndCheckedIsFalseOrderByCreatedAtDesc(smsCodeDTO.getEmail(), smsCodeDTO.getCode());

        //KELGAN KODNI TEKSHIRIB SMSCODE NI CHECKED VA USER NI VERIFICETED QILDIM
        User user = smsCodeVerifiedTrueGetUser(optionalSmsCode);
        return ApiResult.success(generateToken(user));
    }


    @Override
    public TokenDTO generateToken(User user) {
        //HOZIRGI VAQT
        Timestamp issuedAt = new Timestamp(System.currentTimeMillis());

        //USER ORQALI TOKEN OLYABMIZ
        String token = jwtProvider.generateAccessToken(user, issuedAt);

        //TOKEN NI DTO QILIB BERYABMIZ
        return TokenDTO.builder()
                .tokenType(Rest.TYPE_TOKEN)
                .accessToken(token)
                .build();
    }

    @Override
    public User checkPhoneNumberAndPasswordAndEtcAndSetAuthenticationOrThrow(String email, String password) {
        try {
            Authentication authentication = authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return (User) authentication.getPrincipal();
        } catch (DisabledException | LockedException | CredentialsExpiredException disabledException) {
            throw RestException.restThrow(Message.USER_NOT_FOUND_OR_DISABLED, Rest.USER_NOT_ACTIVE, HttpStatus.FORBIDDEN);
        } catch (BadCredentialsException | UsernameNotFoundException badCredentialsException) {
            throw RestException.restThrow(Message.LOGIN_OR_PASSWORD_ERROR, Rest.INCORRECT_USERNAME_OR_PASSWORD, HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public void emailIfExistsThrow(String email) {
        if (userRepository.existsByEmailAndVerifiedUserIsTrue(email)) {
            throw RestException.restThrow(Message.USER_ALREADY_REGISTERED, Rest.EMAIL_OR_PHONE_EXIST, HttpStatus.BAD_REQUEST);
        }
    }

    private User saveNotVerifiedUser(SignUpDTO signUpDTO) {
        Optional<User> optionalUser = userRepository.findFirstByEmailAndVerifiedUserIsFalseOrderByCreatedAtDesc(signUpDTO.getEmail());
        return optionalUser.orElseGet(() -> userRepository.save(User.builder()
                .password(passwordEncoder.encode(signUpDTO.getPassword()))
                .name(signUpDTO.getName())
                .attachment(signUpDTO.getAttachmentId() != null ? attachmentRepository.findById(signUpDTO.getAttachmentId()).orElse(null) : null)
                .email(signUpDTO.getEmail())
                .phoneNumber(signUpDTO.getPhone())
                .verifiedUser(false)
                .role(roleRepository.findByRoleName(signUpDTO.getRoleName()))
                .accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).accountNonExpired(true).enabled(true)
                .build()));
    }

    private void ifRoleAdminThrow(SignUpDTO signUpDTO) {
        if (!signUpDTO.getRoleName().name().equals(RoleName.ROLE_PARENT.name()) && !signUpDTO.getRoleName().name().equals(RoleName.ROLE_STUDENT.name())) {
            throw RestException.restThrow(Message.NOT_FOUND_ROLE, HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    User smsCodeVerifiedTrueGetUser(Optional<SmsCode> optionalSmsCode) {
        if (optionalSmsCode.isEmpty())
            throw RestException.restThrow(Message.CONFIRMATION_CODE_INCORRECT, HttpStatus.CONFLICT);
        SmsCode smsCode = optionalSmsCode.get();
        smsCode.setChecked(true);
        smsCodeRepository.save(smsCode);
        Optional<User> optionalUser = userRepository.findFirstByEmailAndVerifiedUserIsFalseOrderByCreatedAtDesc(smsCode.getEmail());
        User user = optionalUser.orElseThrow();
        user.setVerifiedUser(true);
        return userRepository.save(user);
    }

    private void emailIfNotFoundThrow(String email) {
        if (userRepository.findFirstByEmailAndVerifiedUserIsTrueOrderByCreatedAtDesc(email).isEmpty())
            throw RestException.restThrow(MessageService.getMessage(Message.NOT_FOUND_EMAIL), HttpStatus.FORBIDDEN);
    }
}
