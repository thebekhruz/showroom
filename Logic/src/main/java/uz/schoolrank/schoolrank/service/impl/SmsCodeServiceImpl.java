package uz.schoolrank.schoolrank.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import uz.schoolrank.schoolrank.service.abs.SmsCodeService;
import uz.schoolrank.schoolrank.utills.constants.Rest;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class SmsCodeServiceImpl implements SmsCodeService {
    private final JavaMailSender mailSender;

    @Override
    public void send(String email, String body) {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//
//        MimeMessageHelper helper = null;
//        try {
//            helper = new MimeMessageHelper(mimeMessage, true);
//            helper.setSubject(Rest.COMPANY);
//            helper.setTo(email);
//            helper.setText(body);
//            mailSender.send(mimeMessage);
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }

    }
}
