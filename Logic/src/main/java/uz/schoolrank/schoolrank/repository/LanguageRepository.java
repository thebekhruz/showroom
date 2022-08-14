package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.schoolrank.schoolrank.entity.Language;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
