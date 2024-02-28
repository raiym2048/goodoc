package kg.mozgohack.goodoc.repository;

import kg.mozgohack.goodoc.entities.TakeTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakeTimeRepository extends JpaRepository<TakeTime, Long> {
}
