package uz.schoolrank.schoolrank.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.schoolrank.schoolrank.entity.Question;
import uz.schoolrank.schoolrank.payload.interfaceDTO.PopularDiscussionDTO;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {

    @Query(nativeQuery = true, value = "select cast(q.id as varchar) as id, q.title, q.body, u.name as username, q.created_at as writtenTime, a.original_name as photoUrl\n" +
            "from question q join users u on u.id = q.user_id left join attachment a on a.id = q.attachment_id\n" +
            "left join answer a2 on q.id = a2.question_id group by q.id, q.title, q.body, u.name, q.created_at, a.original_name\n" +
            "order by count(a2.*) desc")
    List<PopularDiscussionDTO> allPopularDiscussions(Pageable pageable);

}
