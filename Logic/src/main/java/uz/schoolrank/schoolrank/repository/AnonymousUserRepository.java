package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.AnonymousUser;

import java.util.UUID;

public interface AnonymousUserRepository extends JpaRepository<AnonymousUser, UUID> {
}

