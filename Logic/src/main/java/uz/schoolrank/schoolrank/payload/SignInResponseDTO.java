package uz.schoolrank.schoolrank.payload;

import java.util.List;
import java.util.Map;

public class SignInResponseDTO {

    //AGAR MIJOZGA SMS YUBORILGAN BO'LSA USHBU FIELD QAYTADI, QOLGAN FILDLAR QAYTAMAYDI
    private SmsCodeDTO smsCode;

    private List<Map<String, String>> options;

    //AGAR MIJOZGA SMS YUBRILMASA USHBU FIELD QAYTADI, QOLGAN FILDLAR QAYTAMAYDI
    private TokenDTO token;

    private boolean hasToken;
}
