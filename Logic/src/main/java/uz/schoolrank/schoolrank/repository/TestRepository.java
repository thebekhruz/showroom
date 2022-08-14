package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.schoolrank.schoolrank.entity.Test;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {
}
