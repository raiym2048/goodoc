package kg.mozgohack.goodoc.controller;

import kg.mozgohack.goodoc.dto.medicine.MedicineRequest;
import kg.mozgohack.goodoc.dto.medicine.MedicineResponse;
import kg.mozgohack.goodoc.dto.medicine.MedicineTypeResponse;
import kg.mozgohack.goodoc.dto.medicine.TakeTimeDaysResponse;
import kg.mozgohack.goodoc.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class MedicineController {
    private final MedicineService medicineService;

    @PostMapping("/add")
    public void addMedicine(@RequestHeader("Authorization") String token, @RequestBody MedicineRequest request){
        medicineService.addMedicine(token, request);
    }

    @GetMapping("/medicine/types")
    public List<MedicineTypeResponse> medicineTypeResponses(){
        return medicineService.getAllMedicineTypes();
    }

    @GetMapping("/take/time/days/all")
    public List<TakeTimeDaysResponse> takeTimeResponses(){
        return medicineService.getAllTakeTimeDays();
    }

    @GetMapping("/client/medicines")
    public List<MedicineResponse> medicineResponses(@RequestHeader("Authorization") String token){
        return medicineService.clientMedicines(token);
    }

    @PostMapping("/take")
    public Boolean takeMedicine(@RequestHeader("Authorization") String token, @RequestParam Long medicineId, @RequestParam String value){
       return medicineService.takeMedicine(token, medicineId, value);
    }
}

