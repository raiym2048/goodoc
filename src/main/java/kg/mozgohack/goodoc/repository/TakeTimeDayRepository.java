package kg.mozgohack.goodoc.repository;

import kg.mozgohack.goodoc.entities.TakeTimeDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TakeTimeDayRepository extends JpaRepository<TakeTimeDay, Long> {
    Optional<TakeTimeDay> findByName(String name);
}
