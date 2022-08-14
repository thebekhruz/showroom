package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.Rank;

import java.util.UUID;

public interface RankRepository extends JpaRepository<Rank, UUID> {
}
