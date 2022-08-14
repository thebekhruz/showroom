package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.Ads;

import java.util.UUID;

public interface AdsRepository extends JpaRepository<Ads, UUID> {
}
