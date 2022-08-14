package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.Likes;

import java.util.UUID;

public interface LikesRepository extends JpaRepository<Likes, UUID> {
}


