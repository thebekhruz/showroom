package uz.schoolrank.schoolrank.utills.constants;

import java.util.HashMap;

public interface Rest {

    String[] OPEN_PAGES_FOR_ALL_METHOD = {
            "/api/v1/auth/**",
            "/api/v1/file/**",
            "/api/v1/main-page/**",
    };

    String AUTHORIZATION_HEADER = "Authorization";
    String BASE_PATH_V1 = "/api/v1/";
    String TYPE_TOKEN = "Bearer ";
    String PHONE_NUMBER_REGEX = "^[+][0-9]{9,15}$";
    String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+=])(?=\\S+$).{8,}$";

    String COMPANY = "School Rank";
    String DEFAULT_PAGE_NUMBER = "0";
    String DEFAULT_PAGE_SIZE = "10";

    String FILE_PATH = "files/";

    int CODE_COUNT = 6;

    // Rest Error codes
    int INCORRECT_USERNAME_OR_PASSWORD = 3001;
    int EMAIL_OR_PHONE_EXIST = 3002;
    int EXPIRED = 3003;
    int ACCESS_DENIED = 3004;
    int NOT_FOUND = 3005;
    int INVALID = 3006;
    int REQUIRED = 3007;

    HashMap<String,Integer> errors=new HashMap<>();
    int SERVER_ERROR = 3008;
    int CONFLICT = 3009;
    int NO_ITEMS_FOUND = 3011;
    int CONFIRMATION = 3012;
    int USER_NOT_ACTIVE = 3013;
    int JWT_TOKEN_INVALID = 3014;
}
