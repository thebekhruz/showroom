package uz.schoolrank.schoolrank.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> {
    private Boolean success = false;

    private String message;

    private T data;

    private List<ErrorData> errors;

    //RESPONSE FAQAT BITTA BOOLEANDAN IBORAT BO'LSA
    private ApiResult(Boolean success) {
        this.success = success;
    }

    //SUCCESS RESPONSE WITH DATA
    private ApiResult(T data, Boolean success) {
        this.data = data;
        this.success = success;
    }

    //SUCCESS RESPONSE WITH MESSAGE
    private ApiResult(String message) {
        this.message = message;
        this.success = Boolean.TRUE;
    }

    //ERROR RESPONSE WITH MESSAGE AND ERROR CODE
    private ApiResult(String errorMsg, Integer errorCode) {
        this.success = false;
        this.errors = Collections.singletonList(new ErrorData(errorMsg, errorCode));
    }


    //ERROR RESPONSE WITH ERROR DATA LIST
    private ApiResult(List<ErrorData> errors) {
        this.success = false;
        this.errors = errors;
    }

    public static <E> ApiResult<E> success(E data) {
        return new ApiResult<>(data,true);
    }
    public static <E> ApiResult<E> success(E data, boolean notMessage) {
        return new ApiResult<>(data, true);
    }

    public static <E> ApiResult<E> success() {
        return new ApiResult<>(true);
    }

    public static ApiResult<String> success(String message) {
        return new ApiResult<>(message);
    }

    public static ApiResult<ErrorData> error(List<ErrorData> errors) {
        return new ApiResult<>(errors);
    }

    public static ApiResult<ErrorData> error(String errorMsg, Integer errorCode) {
        return new ApiResult<>(errorMsg, errorCode);
    }
}
