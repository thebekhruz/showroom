package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.Newsletter;

import java.util.UUID;

public interface NewsletterRepository extends JpaRepository<Newsletter, UUID> {
}