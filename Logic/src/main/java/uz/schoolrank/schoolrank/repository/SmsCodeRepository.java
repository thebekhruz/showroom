package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.SmsCode;

import java.util.Optional;
import java.util.UUID;

public interface SmsCodeRepository extends JpaRepository<SmsCode, UUID> {
    Optional<SmsCode> findFirstByEmailAndCodeOrderByCreatedAtDesc(String email, String code);
    Optional<SmsCode> findFirstByEmailAndCodeAndCheckedIsFalseOrderByCreatedAtDesc(String email, String code);
}
