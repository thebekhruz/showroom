package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.SubRank;

import java.util.UUID;

public interface SubRankRepository extends JpaRepository<SubRank, UUID> {
}
