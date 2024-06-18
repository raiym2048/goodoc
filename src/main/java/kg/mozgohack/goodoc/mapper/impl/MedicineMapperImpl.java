package kg.mozgohack.goodoc.mapper.impl;

import kg.mozgohack.goodoc.dto.medicine.MedicineResponse;
import kg.mozgohack.goodoc.entities.Medicine;
import kg.mozgohack.goodoc.entities.User;
import kg.mozgohack.goodoc.mapper.MedicineMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MedicineMapperImpl implements MedicineMapper {
    @Override
    public List<MedicineResponse> toDtoS(List<Medicine> userMedicines, User user) {
        List<MedicineResponse> responses = new ArrayList<>();
        for (Medicine medicine: userMedicines){
            responses.add(toDto(medicine, user));
        }
        return responses;
    }

    private MedicineResponse toDto(Medicine medicine, User user) {
        MedicineResponse medicineResponse = new MedicineResponse();
        medicineResponse.setName(medicine.getName());
        medicineResponse.setMedicineId(medicine.getId());
        medicineResponse.setType(medicine.getType().getName());
        medicineResponse.setCount(medicine.getCount());
        if (user.getTakenMedicine().contains(medicine)){
            medicineResponse.setStatus("принято");
        }
        else {
            medicineResponse.setStatus("еще не принято");
        }
        return medicineResponse;
    }
}
