package uz.schoolrank.schoolrank.payload.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.schoolrank.schoolrank.utills.constants.Message;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressReqDTO {

    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private double lan;

    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private double lat;

}
