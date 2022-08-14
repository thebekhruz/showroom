package uz.schoolrank.schoolrank.payload.res;

import lombok.Builder;
import lombok.Data;
import uz.schoolrank.schoolrank.entity.*;
import uz.schoolrank.schoolrank.payload.*;

import java.util.List;

@Data
@Builder
public class OnlineFormGetDTO {

    //SOCIAL, ENVIRONMENTAL AWARDS ...
    private List<AwardsDTO> awardsList;

    //MATH, BIOLOGY, ART ..
    private List<SubjectDTO> subjectList;

    //UZ, RU ...
    private List<Language> languageList;

    //IB, A-LEVELS
    private List<EducationSystemDTO> systemList;

    //SECONDARY SCHOOL, HIGH SCHOOL ....
    private List<StageDTO> stageList;

    //IELTS, SAT
    private List<TestDTO> testList;

    //MATH, ENGLISH, SPORT ...
    private List<ActivityDTO> activityList;

    private List<District> districtList;

}
