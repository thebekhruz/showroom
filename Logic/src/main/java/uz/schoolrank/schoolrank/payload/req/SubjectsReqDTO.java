package uz.schoolrank.schoolrank.payload.req;

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
public class SubjectsReqDTO {

    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private UUID id;

    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private double mark;

}
