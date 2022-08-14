package uz.schoolrank.schoolrank.payload.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.schoolrank.schoolrank.utills.constants.Message;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OnlineFormAddDTO {

    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private SchoolDetailReqDTO schoolDetailReqDTO;

    //AWARDS ID LIST
    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private List<Long> awardsId;

    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private List<StageReqDTO> stages;

    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private List<TestReqDTO> tests;

    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private List<AdmissionReqDTO> admissions;

    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private List<SubjectsReqDTO> subjects;

    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private Long languageId;

    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private Long systemId;

    @NotNull(message = Message.SOMETHING_WENT_EMPTY)
    private List<ActivityReqDTO> activities;

}
