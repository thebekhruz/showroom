package uz.schoolrank.schoolrank.utills;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.schoolrank.schoolrank.entity.User;

import java.util.ArrayList;
import java.util.Locale;

public class CommonUtils {

    //SECURITY CONTEX DAN USERNI OLISH
    public static User getUserFromSecurityContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null
                || !authentication.isAuthenticated()
                || "anonymousUser".equals("" + authentication.getPrincipal()))
            return null;
        return (User) authentication.getPrincipal();
    }
    //SECURITY CONTEX GA USERNI JOYLASH
    public static void setUserToSecurityContext(User user) {
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>()));
    }
    public static String getLocaleLanguage() {
        Locale locale = LocaleContextHolder.getLocale();
        String language = locale.getLanguage();

        return language == null ? "" : language;
    }
}
