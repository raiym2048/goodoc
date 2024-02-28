package kg.mozgohack.goodoc.mapper.impl;

import kg.mozgohack.goodoc.dto.medicine.MedicineTypeResponse;
import kg.mozgohack.goodoc.entities.MedicineType;
import kg.mozgohack.goodoc.mapper.MedicineTypeMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MedicineTypeMapperImpl implements MedicineTypeMapper {
    @Override
    public List<MedicineTypeResponse> toDtoS(List<MedicineType> all) {
        List<MedicineTypeResponse> responses = new ArrayList<>();
        for (MedicineType medicineType: all){
            responses.add(toDto(medicineType));
        }
        return responses;
    }

    @Override
    public MedicineTypeResponse toDto(MedicineType medicineType) {
        MedicineTypeResponse response = new MedicineTypeResponse();
        response.setName(medicineType.getName());
        return response;
    }
}
