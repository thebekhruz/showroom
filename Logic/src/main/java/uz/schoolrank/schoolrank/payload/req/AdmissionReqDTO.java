package uz.schoolrank.schoolrank.payload.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.schoolrank.schoolrank.utills.constants.Message;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionReqDTO {

    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private int count;

    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private boolean accepted;

}
