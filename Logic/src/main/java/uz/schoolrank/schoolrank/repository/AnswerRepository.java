package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.Answer;

import java.util.UUID;

public interface AnswerRepository extends JpaRepository<Answer, UUID> {
}
