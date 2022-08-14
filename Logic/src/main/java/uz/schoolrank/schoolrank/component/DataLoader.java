package uz.schoolrank.schoolrank.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.schoolrank.schoolrank.entity.*;
import uz.schoolrank.schoolrank.enums.LanguageName;
import uz.schoolrank.schoolrank.enums.RoleName;
import uz.schoolrank.schoolrank.repository.*;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final SubjectRepository subjectRepository;
    private final AwardsRepository awardsRepository;
    private final StageRepository stageRepository;
    private final EducationSystemRepository educationSystemRepository;
    private final RoleRepository roleRepository;
    private final LanguageRepository languageRepository;
    private final TestRepository testRepository;
    private final ActivityRepository activityRepository;
    private final DistrictRepository districtRepository;

    @Value("${spring.sql.init.mode}")
    private String mode;


    @Override
    public void run(String... args) {
        if (mode.equals("always")){
            addLanguages();
            addRoles();
            addAwards();
            addSubjects();
            addStages();
            addEducationSystem();
            addTest();
            addActivity();
            addDistrict();
        }
    }

    public void addLanguages(){
        Language ru = Language.builder()
                .languageName(LanguageName.RU)
                .build();

        Language uz = Language.builder()
                .languageName(LanguageName.UZ)
                .build();

        languageRepository.saveAll(new ArrayList<>(List.of(ru, uz)));
    }

    public void addRoles(){
        Role admin = Role.builder()
                .roleName(RoleName.ROLE_ADMIN)
                .build();

        Role parent = Role.builder()
                .roleName(RoleName.ROLE_PARENT)
                .build();

        Role student = Role.builder()
                .roleName(RoleName.ROLE_STUDENT)
                .build();

        roleRepository.saveAll(new ArrayList<>(List.of(admin, student, parent)));
    }

    public void addSubjects(){
        //MATH
        Subject math = Subject.builder()
                .name("Math")
                .science(true)
                .build();

        //BIOLOGY
        Subject biology = Subject.builder()
                .name("Biology")
                .science(true)
                .build();

        //PHYSICS
        Subject physics = Subject.builder()
                .name("Physics")
                .science(true)
                .build();

        //CHEMISTRY
        Subject chemistry = Subject.builder()
                .name("Chemistry")
                .science(true)
                .build();

        //ART
        Subject art = Subject.builder()
                .name("Art")
                .science(false)
                .build();

        //MUSIC
        Subject music = Subject.builder()
                .name("Music")
                .science(false)
                .build();

        subjectRepository.saveAll(new ArrayList<>(List.of(math, biology, physics, chemistry, art, music)));
    }

    public void addAwards(){
        //SOCIAL AWARD
        Awards social_award = Awards.builder()
                .name("Social award")
                .description("...")
                .build();

        //ENVIRONMENTAL AWARD
        Awards environmental_award = Awards.builder()
                .name("Environmental award")
                .description("...")
                .build();

        //SPORT AWARD
        Awards sport_award = Awards.builder()
                .name("Sport award")
                .description("...")
                .build();

        awardsRepository.saveAll(new ArrayList<>(List.of(social_award, environmental_award, sport_award)));
    }

    public void addStages(){
        Stage elementary_school = Stage.builder()
                .name("Elementary school")
                .build();

        Stage secondary_school = Stage.builder()
                .name("Secondary school")
                .build();

        Stage high_school = Stage.builder()
                .name("High school")
                .build();

        stageRepository.saveAll(new ArrayList<>(List.of(elementary_school, secondary_school, high_school)));
    }

    public void addEducationSystem(){
        EducationSystem ib = EducationSystem.builder()
                .name("IB")
                .build();

        EducationSystem a_levels = EducationSystem.builder()
                .name("A-levels")
                .build();

        educationSystemRepository.saveAll(new ArrayList<>(List.of(ib, a_levels)));
    }

    public void addTest(){
        Test ielts = Test.builder()
                .name("IELTS")
                .maxScore(9)
                .build();

        Test sat = Test.builder()
                .name("SAT")
                .maxScore(1600)
                .build();

        testRepository.saveAll(new ArrayList<>(List.of(ielts, sat)));
    }

    public void addActivity(){
        Activity math = Activity.builder()
                .name("Math")
                .sport(false)
                .build();

        Activity english = Activity.builder()
                .name("English")
                .sport(false)
                .build();

        Activity sciences = Activity.builder()
                .name("Sciences")
                .sport(false)
                .build();

        Activity sport = Activity.builder()
                .name("Sport")
                .sport(true)
                .build();

        activityRepository.saveAll(new ArrayList<>(List.of(math, english, sciences, sport)));
    }

    public void addDistrict(){
       List<District> districtList = new ArrayList<>();
        districtList.add(new District("Bektemir district"));
        districtList.add(new District("Mirzo Ulugbek district"));
        districtList.add(new District("Mirobod district"));
        districtList.add(new District("Olmazor district"));
        districtList.add(new District("Sirgali district"));
        districtList.add(new District("Uchtepa district"));
        districtList.add(new District("Yashnobod district"));
        districtList.add(new District("Chilonzor district"));
        districtList.add(new District("Shaykhontokhur district"));
        districtList.add(new District("Yunusobod district"));
        districtList.add(new District("Yakkasaroy district"));
        districtList.add(new District("Yangihayot district"));
        districtRepository.saveAll(districtList);
    }
}
