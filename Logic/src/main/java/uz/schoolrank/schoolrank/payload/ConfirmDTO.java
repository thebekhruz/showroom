package uz.schoolrank.schoolrank.payload;

import lombok.Data;
import uz.schoolrank.schoolrank.utills.constants.Message;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class ConfirmDTO {

    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private UUID schoolId;

    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private int rank;

    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private boolean accept; //TRUE -> ACCEPT, FALSE -> REJECT

}
