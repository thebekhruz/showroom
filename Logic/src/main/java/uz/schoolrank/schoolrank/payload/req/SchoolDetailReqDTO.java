package uz.schoolrank.schoolrank.payload.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.schoolrank.schoolrank.utills.constants.Message;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchoolDetailReqDTO {

    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private String schoolName;

    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private String description;

    private UUID logoId;

    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private AddressReqDTO address;

    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private String website;

//    @Pattern(regexp = "^(\\+\\d{1,13})$", message = "PHONE NUMBER FORMAT MUST BE : (+998) XX XXX-XX-XX")
//    @Size(min = 13,max = 13)
    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private String phoneNumber;

    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private String email;

    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private String fax;

    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private Long districtId;

    //4 YEAR GRADUATION RATE
    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private double graduationRate;

}
