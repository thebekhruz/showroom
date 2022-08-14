package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.SchoolStage;

import java.util.UUID;

public interface SchoolStageRepository extends JpaRepository<SchoolStage, UUID> {
}
