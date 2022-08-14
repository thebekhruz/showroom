package uz.schoolrank.schoolrank.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignInDTO {
    @NotBlank(message = "email ni ber")
    private String email;
    @NotBlank(message = "password ni ber")
    private String password;
}
