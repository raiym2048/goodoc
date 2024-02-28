package kg.mozgohack.goodoc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private MedicineType type;
    @ManyToOne
    private TakeTime takeTime;
    private Integer count;


}
