package uz.schoolrank.schoolrank.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.schoolrank.schoolrank.utills.constants.Rest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
    @NotBlank(message = "{SHOULD_NOT_BE_EMPTY} " + "Email")
    @Pattern(regexp = Rest.EMAIL_REGEX, message = "{EMAIL_REGEX_FORMAT}")
    String email;
}
