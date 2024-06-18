package kg.mozgohack.goodoc.mapper;

import kg.mozgohack.goodoc.dto.medicine.MedicineResponse;
import kg.mozgohack.goodoc.entities.Medicine;
import kg.mozgohack.goodoc.entities.User;

import java.util.List;

public interface MedicineMapper {
    List<MedicineResponse> toDtoS(List<Medicine> userMedicines, User user);
}
