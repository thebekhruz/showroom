package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.Admission;

import java.util.UUID;

public interface AdmissionRepository extends JpaRepository<Admission, UUID> {
}