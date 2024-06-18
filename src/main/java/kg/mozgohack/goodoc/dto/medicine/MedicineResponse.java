package kg.mozgohack.goodoc.dto.medicine;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MedicineResponse {
    private Long medicineId;
    private String name;
    private String type;
    private int count;
    private String status;

    private LocalDateTime takeTime;

}
