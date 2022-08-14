package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.Oauth2User;

import java.util.UUID;

public interface Oauth2UserRepository extends JpaRepository<Oauth2User, UUID> {
}
