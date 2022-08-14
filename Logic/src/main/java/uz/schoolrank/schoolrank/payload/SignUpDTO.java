package uz.schoolrank.schoolrank.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.schoolrank.schoolrank.enums.RoleName;
import uz.schoolrank.schoolrank.utills.constants.Rest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpDTO {
    private UUID attachmentId;

    @NotBlank(message = "{SHOULD_NOT_BE_EMPTY}")
    private String name;

    @NotBlank(message = "{SHOULD_NOT_BE_EMPTY}")
    @Pattern(regexp = Rest.EMAIL_REGEX, message = "{EMAIL_REGEX_FORMAT}")
    private String email;
    //    @NotBlank(message = "{PHONE_NUMBER_SHOULD_NOT_BE_EMPTY}")
    private String phone;
    @NotBlank(message = "{SHOULD_NOT_BE_EMPTY}")
    @Pattern(regexp = Rest.PASSWORD_REGEX, message = "Password " + "{STANDARD}")
    private String password;

    @NotBlank(message = "{SHOULD_NOT_BE_EMPTY}")
    @Pattern(regexp = Rest.PASSWORD_REGEX, message = "Password " + "{STANDARD}")
    private String prePassword;

    @NotNull(message = "roleni ber")
    private RoleName roleName;

}
