package uz.schoolrank.schoolrank.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.schoolrank.schoolrank.entity.School;
import uz.schoolrank.schoolrank.payload.interfaceDTO.SchoolDTO;

import java.util.List;
import java.util.UUID;

public interface SchoolRepository extends JpaRepository<School, UUID> {

    boolean existsByNameOrPhoneNumberOrEmail(String name, String phoneNumber, String email);

    @Query(nativeQuery = true, value = "select cast(s.id as varchar) as id, s.name from school s where s.is_accepted=true and upper(s.name) like %:name%")
    List<SchoolDTO> search(String name, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from school s where s.is_accepted=false")
    List<School> getWaitingSchools(Pageable pageable);
}
