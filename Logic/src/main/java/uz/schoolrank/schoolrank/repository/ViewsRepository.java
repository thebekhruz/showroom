package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.schoolrank.schoolrank.entity.Views;

import java.util.UUID;

public interface ViewsRepository extends JpaRepository<Views, UUID> {

    @Query(nativeQuery = true, value = "select count(v.*) from views v join question q on q.id = v.question_id where q.id=:question_id")
    long countOfViews(UUID question_id);

}
