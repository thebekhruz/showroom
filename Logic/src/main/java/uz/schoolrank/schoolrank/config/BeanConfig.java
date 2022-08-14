package uz.schoolrank.schoolrank.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.mail.Session;
import java.util.Properties;

@Configuration
public class BeanConfig {
    @Bean
    JavaMailSender sender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("hasanboymaxmudov2003@gmail.com");
        mailSender.setPassword("Hasan2003");
        mailSender.setUsername("com.uz.ferlex@gmail.com");
        mailSender.setPassword("57246abs");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        mailSender.setSession(Session.getInstance(props));
        return mailSender;
    }


}
