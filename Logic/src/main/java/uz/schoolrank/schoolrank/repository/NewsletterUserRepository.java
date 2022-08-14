package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.NewsletterUser;

import java.util.UUID;

public interface NewsletterUserRepository extends JpaRepository<NewsletterUser, UUID> {

    boolean existsByEmail(String email);

}
