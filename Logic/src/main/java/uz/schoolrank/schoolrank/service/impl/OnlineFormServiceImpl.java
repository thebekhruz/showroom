package uz.schoolrank.schoolrank.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.schoolrank.schoolrank.entity.*;
import uz.schoolrank.schoolrank.exceptions.RestException;
import uz.schoolrank.schoolrank.mapper.*;
import uz.schoolrank.schoolrank.payload.*;
import uz.schoolrank.schoolrank.payload.req.*;
import uz.schoolrank.schoolrank.payload.res.OnlineFormGetDTO;
import uz.schoolrank.schoolrank.repository.*;
import uz.schoolrank.schoolrank.service.abs.OnlineFormService;
import uz.schoolrank.schoolrank.utills.constants.Message;
import uz.schoolrank.schoolrank.utills.constants.Rest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OnlineFormServiceImpl implements OnlineFormService {

    private final SubjectRepository subjectRepository;
    private final AwardsRepository awardsRepository;
    private final StageRepository stageRepository;
    private final EducationSystemRepository educationSystemRepository;
    private final LanguageRepository languageRepository;
    private final TestRepository testRepository;
    private final ActivityRepository activityRepository;
    private final SchoolRepository schoolRepository;
    private final AddressRepository addressRepository;
    private final AttachmentRepository attachmentRepository;
    private final SchoolTestRepository schoolTestRepository;
    private final SchoolStageRepository schoolStageRepository;
    private final DistrictRepository districtRepository;
    private final AdmissionRepository admissionRepository;
    private final SchoolSubjectRepository schoolSubjectRepository;
    private final SchoolActivityRepository schoolActivityRepository;
    private final ActivityMapper activityMapper;
    private final AwardMapper awardMapper;
    private final EducationSystemMapper educationSystemMapper;
    private final StageMapper stageMapper;
    private final SubjectMapper subjectMapper;
    private final TestMapper testMapper;


    @Override
    public ApiResult<List<School>> getWaitingSchools(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ApiResult.success(schoolRepository.getWaitingSchools(pageable));
    }

    @Override
    public ApiResult<?> approveOrRejectSchools(ConfirmDTO dto) {

        //FRONTENDCHI TOG'RI ID BERGANINI TEKSHIRISH
        School school = schoolIfEmptyThrow(dto);
        if (!dto.isAccept()) {
            schoolRepository.deleteById(dto.getSchoolId());
            return ApiResult.success(Message.SCHOOL_REJECTED);
        } else {
            school.setRankAdmin(dto.getRank());
            school.setAccepted(dto.isAccept());
            return ApiResult.success(Message.SCHOOL_APPROVED);
        }
    }




    @Override
    public ApiResult<OnlineFormGetDTO> getDataForOnlineForm() {
        OnlineFormGetDTO dto = OnlineFormGetDTO.builder()
                .awardsList(awardMapper.toDTOList(awardsRepository.findAll()))
                .languageList(languageRepository.findAll())
                .stageList(stageMapper.toDTOList(stageRepository.findAll()))
                .subjectList(subjectMapper.toDTOList(subjectRepository.findAll()))
                .systemList(educationSystemMapper.toDTOList(educationSystemRepository.findAll()))
                .testList(testMapper.toDTOList(testRepository.findAll()))
                .activityList(activityMapper.toDTOList(activityRepository.findAll()))
                .districtList(districtRepository.findAll())
                .build();
        return ApiResult.success(dto);
    }

    @Transactional
    @Override
    public ApiResult<?> saveOnlineForm(OnlineFormAddDTO dto, User user) {
        if (schoolRepository.existsByNameOrPhoneNumberOrEmail(dto.getSchoolDetailReqDTO().getSchoolName(),
                dto.getSchoolDetailReqDTO().getPhoneNumber(), dto.getSchoolDetailReqDTO().getEmail()))
            throw RestException.restThrow(Message.SCHOOL_NAME_OR_PHONE_NUMBER_OR_EMAIL_ALREADY_EXISTED, HttpStatus.BAD_REQUEST);
        else if (!(languageRepository.existsById(dto.getLanguageId()) &&
                districtRepository.existsById(dto.getSchoolDetailReqDTO().getDistrictId()) &&
                educationSystemRepository.existsById(dto.getSystemId())))
            throw RestException.restThrow(Message.ID_NOT_FOUND, HttpStatus.BAD_REQUEST);
        else if (dto.getLanguageId() == null || dto.getSchoolDetailReqDTO().getDistrictId() == null || dto.getSystemId() == null) {
            throw RestException.restThrow(Message.ID_WENT_NULL, HttpStatus.BAD_REQUEST);
        }
        //SAVE ADDRESS
        Address address = Address.builder()
                .lan(dto.getSchoolDetailReqDTO().getAddress().getLan())
                .lat(dto.getSchoolDetailReqDTO().getAddress().getLat())
                .build();
        Address savedAddress = addressRepository.save(address);

        //SAVE SCHOOL
        School school = School.builder()
                .name(dto.getSchoolDetailReqDTO().getSchoolName())
                .description(dto.getSchoolDetailReqDTO().getDescription())
                .email(dto.getSchoolDetailReqDTO().getEmail())
                .phoneNumber(dto.getSchoolDetailReqDTO().getPhoneNumber())
                .fax(dto.getSchoolDetailReqDTO().getFax())
                .website(dto.getSchoolDetailReqDTO().getWebsite())
                .address(addressRepository.findById(savedAddress.getId()).orElse(null))
                .logo(attachmentRepository.findById(dto.getSchoolDetailReqDTO().getLogoId()).orElse(null))
                .language(languageRepository.findById(dto.getLanguageId()).orElse(null))
                .system(educationSystemRepository.findById(dto.getSystemId()).orElse(null))
                .district(districtRepository.findById(dto.getSchoolDetailReqDTO().getDistrictId()).orElse(null))
                .graduationRate(dto.getSchoolDetailReqDTO().getGraduationRate())
                .user(user)
                .build();
        School savedSchool = schoolRepository.save(school);

        //SAVE SCHOOL_TEST
        for (TestReqDTO test : dto.getTests()) {
            if (test.getId() == null || !testRepository.existsById(test.getId()))
                throw RestException.restThrow(Message.ID_NOT_FOUND, HttpStatus.BAD_REQUEST);
            SchoolTest schoolTest = SchoolTest.builder()
                    .test(testRepository.findById(test.getId()).orElse(null))
                    .averageScore(test.getScore())
                    .participationRate(test.getParticipationRate())
                    .school(savedSchool)
                    .build();
            schoolTestRepository.save(schoolTest);
        }

        //SAVE SCHOOL_STAGE
        for (StageReqDTO stage : dto.getStages()) {
            if (stage.getId() == null || !stageRepository.existsById(stage.getId()))
                throw RestException.restThrow(Message.ID_NOT_FOUND, HttpStatus.BAD_REQUEST);
            SchoolStage schoolStage = SchoolStage.builder()
                    .stage(stageRepository.findById(stage.getId()).orElse(null))
                    .count(stage.getCount())
                    .school(savedSchool)
                    .build();
            schoolStageRepository.save(schoolStage);
        }

        //SAVE ADMISSION
        for (AdmissionReqDTO admission : dto.getAdmissions()) {
            Admission admission1 = Admission.builder()
                    .count(admission.getCount())
                    .status(admission.isAccepted())
                    .school(savedSchool)
                    .build();
            admissionRepository.save(admission1);
        }

        //SAVE SCHOOL_SUBJECTS
        for (SubjectsReqDTO subject : dto.getSubjects()) {
            if (subject.getId() == null || !subjectRepository.existsById(subject.getId()))
                throw RestException.restThrow(Message.ID_NOT_FOUND, HttpStatus.BAD_REQUEST);
            SchoolSubject schoolSubject = SchoolSubject.builder()
                    .subject(subjectRepository.findById(subject.getId()).orElse(null))
                    .grade(subject.getMark())
                    .school(savedSchool)
                    .build();
            schoolSubjectRepository.save(schoolSubject);
        }

        //SAVE SCHOOL_ACTIVITY
        for (ActivityReqDTO activity : dto.getActivities()) {
            if (activity.getId() == null || !activityRepository.existsById(activity.getId()))
                throw RestException.restThrow(Message.ID_NOT_FOUND, HttpStatus.BAD_REQUEST);
            SchoolActivity schoolActivity = SchoolActivity.builder()
                    .hour(activity.getHour())
                    .activity(activityRepository.findById(activity.getId()).orElse(null))
                    .school(savedSchool)
                    .build();
            schoolActivityRepository.save(schoolActivity);
        }

        //SET SCHOOL TO AWARDS
        List<Awards> awardsList = awardsRepository.findAllById(dto.getAwardsId());
        for (Awards awards : awardsList) {
            awards.setSchoolList(Collections.singletonList(savedSchool));
        }
        return ApiResult.success(Message.ONLINE_FORM_ADDED_SUCCESSFULLY);
    }


    private School schoolIfEmptyThrow(ConfirmDTO dto) {
        Optional<School> optionalSchool = schoolRepository.findById(dto.getSchoolId());
        if (optionalSchool.isEmpty())
            throw RestException.restThrow(Message.ID_NOT_FOUND, HttpStatus.BAD_REQUEST);
        return optionalSchool.get();
    }

}
