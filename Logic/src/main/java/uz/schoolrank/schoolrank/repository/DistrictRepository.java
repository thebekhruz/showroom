package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.District;

public interface DistrictRepository extends JpaRepository<District, Long> {
}
