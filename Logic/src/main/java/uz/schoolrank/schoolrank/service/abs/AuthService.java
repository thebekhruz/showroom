package uz.schoolrank.schoolrank.service.abs;

import org.springframework.web.bind.annotation.RequestBody;
import uz.schoolrank.schoolrank.entity.User;
import uz.schoolrank.schoolrank.payload.*;

public interface AuthService {
    //EMAIL VA PAROL ORQALI LOGIN BO'LISH
    ApiResult<TokenDTO> signIn(@RequestBody SignInDTO signInDTO);

    ApiResult<String> signUp(SignUpDTO signUpDTO);

    TokenDTO generateToken(User user);

    User checkPhoneNumberAndPasswordAndEtcAndSetAuthenticationOrThrow(String email, String password);

    void emailIfExistsThrow(String email);


    ApiResult<TokenDTO> verify(SmsCodeDTO smsCodeDTO);
}
