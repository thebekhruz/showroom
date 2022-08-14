package uz.schoolrank.schoolrank.service.abs;

import javax.mail.MessagingException;

public interface SmsCodeService {
    void send(String email, String body);
}
