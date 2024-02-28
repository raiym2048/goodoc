package kg.mozgohack.goodoc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class TakeTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private TakeTimeDay day;
    private LocalDateTime firstDoseTime;
    private Integer countDose;
}
