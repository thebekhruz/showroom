package uz.schoolrank.schoolrank.controller.v1.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.schoolrank.schoolrank.controller.v1.abs.AuthController;
import uz.schoolrank.schoolrank.payload.ApiResult;
import uz.schoolrank.schoolrank.payload.SignInDTO;
import uz.schoolrank.schoolrank.payload.SignUpDTO;
import uz.schoolrank.schoolrank.payload.TokenDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.schoolrank.schoolrank.controller.v1.abs.AuthController;
import uz.schoolrank.schoolrank.payload.*;
import uz.schoolrank.schoolrank.service.abs.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final AuthService authService;

    @Override
    public ApiResult<TokenDTO> signIn(SignInDTO signInDTO) {
        return authService.signIn(signInDTO);
    }

    @Override
    public ApiResult<String> signUp(SignUpDTO signUpDTO) {
       return authService.signUp(signUpDTO);
    }

    @Override
    public ApiResult<TokenDTO> verify(SmsCodeDTO smsCodeDTO) {
        return authService.verify(smsCodeDTO);
    }

}
