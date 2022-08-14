package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.School;
import uz.schoolrank.schoolrank.entity.SchoolSubject;

import java.util.UUID;

public interface SchoolSubjectRepository extends JpaRepository<SchoolSubject, UUID> {
}