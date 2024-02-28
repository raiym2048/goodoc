package kg.mozgohack.goodoc.mapper;

import kg.mozgohack.goodoc.dto.medicine.MedicineTypeResponse;
import kg.mozgohack.goodoc.entities.MedicineType;

import java.util.List;

public interface MedicineTypeMapper {
    List<MedicineTypeResponse> toDtoS(List<MedicineType> all);

    MedicineTypeResponse toDto(MedicineType medicineType);
}
