package uz.schoolrank.schoolrank.payload.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.schoolrank.schoolrank.utills.constants.Message;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestReqDTO {

    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private Long id;

    //AVERAGE SCORE
    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private double score;

    @NotBlank(message = Message.SOMETHING_WENT_EMPTY)
    private double participationRate;
}
