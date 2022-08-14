package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.schoolrank.schoolrank.entity.Shares;

import java.util.UUID;

public interface SharesRepository extends JpaRepository<Shares, UUID> {

    @Query(nativeQuery = true, value = "select count(s.*) from shares s join question q on q.id = s.question_id where q.id=:question_id")
    long countOfShares(UUID question_id);

}
