package uz.schoolrank.schoolrank.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.schoolrank.schoolrank.exceptions.RestException;
import uz.schoolrank.schoolrank.utills.constants.Message;

import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MainService {

    public void checkPasswordEqualityIfErrorThrow(String password, String prePassword) {
        if (Objects.nonNull(password) && !Objects.equals(password,prePassword)){
            throw RestException.restThrow(Message.PASSWORDS_AND_PRE_PASSWORD_NOT_EQUAL, HttpStatus.BAD_REQUEST);
        }
    }
    public String generateVerificationCode(int countChar) {
        if (countChar > 8 || countChar < 5)
            throw RestException.restThrow(Message.SMS_CODE_MUST_BE_BETWEEN, HttpStatus.BAD_REQUEST);
        return String.valueOf(new Random().nextInt(999999999)).substring(0, countChar);
    }
}
