package kg.mozgohack.goodoc.dto.medicine;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TakeTimeRequest {
    private String name;
    private LocalDateTime firstDoseTime;
    private Integer countDose;
}
