package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.SchoolTest;

import java.util.UUID;

public interface SchoolTestRepository extends JpaRepository<SchoolTest, UUID> {
}
