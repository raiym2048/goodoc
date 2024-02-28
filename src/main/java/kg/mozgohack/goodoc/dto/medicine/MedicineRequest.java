package kg.mozgohack.goodoc.dto.medicine;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class MedicineRequest {
    private String name;
    private String medicineTypeName;
    private TakeTimeRequest takeTimeRequest;
    private Integer count;

}
