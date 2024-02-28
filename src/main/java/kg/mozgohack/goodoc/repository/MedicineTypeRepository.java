package kg.mozgohack.goodoc.repository;

import kg.mozgohack.goodoc.entities.MedicineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicineTypeRepository extends JpaRepository<MedicineType, Long> {
    Optional<MedicineType> findByName(String name);
}
