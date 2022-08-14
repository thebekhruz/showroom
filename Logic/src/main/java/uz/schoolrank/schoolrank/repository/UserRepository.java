package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByIdAndEnabledIsTrueAndAccountNonExpiredIsTrueAndCredentialsNonExpiredIsTrueAndAccountNonLockedIsTrue(UUID id);

    Optional<User> findFirstByEmailAndEnabledIsTrueAndAccountNonExpiredIsTrueAndCredentialsNonExpiredIsTrueAndAccountNonLockedIsTrue(String email);
Optional<User>findByEmail(String email);
    Optional<User> findFirstByEmailAndPassword(String email, String password);

    boolean existsByEmailAndVerifiedUserIsTrue(String email);

    Optional<User> findFirstByEmailAndVerifiedUserIsFalseOrderByCreatedAtDesc(String email);

    Optional<User> findFirstByEmailAndVerifiedUserIsTrueOrderByCreatedAtDesc(String email);
}
