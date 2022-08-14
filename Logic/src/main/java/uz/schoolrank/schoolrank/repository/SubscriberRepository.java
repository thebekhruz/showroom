package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.Subscriber;

import java.util.UUID;

public interface SubscriberRepository extends JpaRepository<Subscriber, UUID> {
}
