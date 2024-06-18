package kg.mozgohack.goodoc.service;

import kg.mozgohack.goodoc.dto.medicine.MedicineRequest;
import kg.mozgohack.goodoc.dto.medicine.MedicineResponse;
import kg.mozgohack.goodoc.dto.medicine.MedicineTypeResponse;
import kg.mozgohack.goodoc.dto.medicine.TakeTimeDaysResponse;

import java.util.List;

public interface MedicineService {
    List<MedicineTypeResponse> getAllMedicineTypes();

    List<TakeTimeDaysResponse> getAllTakeTimeDays();

    void addMedicine(String token, MedicineRequest request);

    Boolean takeMedicine(String token, Long medicineId, String value);

    List<MedicineResponse> clientMedicines(String token);
}
