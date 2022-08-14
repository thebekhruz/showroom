package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.schoolrank.schoolrank.entity.EducationSystem;

import java.util.List;

public interface EducationSystemRepository extends JpaRepository<EducationSystem, Long> {
}


