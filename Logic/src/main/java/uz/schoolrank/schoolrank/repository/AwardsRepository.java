package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.schoolrank.schoolrank.entity.Awards;

import java.util.List;

public interface AwardsRepository extends JpaRepository<Awards, Long> {
}

