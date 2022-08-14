package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.SchoolActivity;

import java.util.UUID;

public interface SchoolActivityRepository extends JpaRepository<SchoolActivity, UUID> {
}


