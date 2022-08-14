package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.Feature;

import java.util.UUID;

public interface FeatureRepository extends JpaRepository<Feature, UUID> {
}
