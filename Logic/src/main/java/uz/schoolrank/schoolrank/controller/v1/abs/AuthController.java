package uz.schoolrank.schoolrank.controller.v1.abs;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.schoolrank.schoolrank.payload.ApiResult;
import uz.schoolrank.schoolrank.payload.SignInDTO;
import uz.schoolrank.schoolrank.payload.SignUpDTO;
import uz.schoolrank.schoolrank.payload.TokenDTO;
import uz.schoolrank.schoolrank.payload.*;
import uz.schoolrank.schoolrank.utills.constants.Rest;

import javax.validation.Valid;

@RequestMapping(AuthController.AUTH)
public interface AuthController {
    String AUTH = Rest.BASE_PATH_V1 + "auth/";
    String LOGIN = AUTH + "sign-in";
    String SIGNUP = AUTH + "sign-up";
    String SMS_CODE = AUTH + "sms-code";

    String FORGOT_PASSWORD = AUTH + "forgot-password";

    @PostMapping(LOGIN)
    ApiResult<TokenDTO> signIn(@Valid @RequestBody SignInDTO signInDTO);


    @PostMapping(SIGNUP)
    ApiResult<String> signUp(@Valid @RequestBody SignUpDTO signUpDTO);


    @PostMapping(SMS_CODE)
    ApiResult<TokenDTO> verify(@Valid @RequestBody SmsCodeDTO smsCodeDTO);

}
