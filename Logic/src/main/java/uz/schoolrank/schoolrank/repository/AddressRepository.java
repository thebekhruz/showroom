package uz.schoolrank.schoolrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.schoolrank.schoolrank.entity.Address;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

}
