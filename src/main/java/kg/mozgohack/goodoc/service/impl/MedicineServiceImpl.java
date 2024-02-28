package kg.mozgohack.goodoc.service.impl;

import kg.mozgohack.goodoc.dto.medicine.MedicineRequest;
import kg.mozgohack.goodoc.dto.medicine.MedicineTypeResponse;
import kg.mozgohack.goodoc.dto.medicine.TakeTimeRequest;
import kg.mozgohack.goodoc.dto.medicine.TakeTimeDaysResponse;
import kg.mozgohack.goodoc.entities.*;
import kg.mozgohack.goodoc.exception.NotFoundException;
import kg.mozgohack.goodoc.mapper.MedicineTypeMapper;
import kg.mozgohack.goodoc.mapper.TakeTimeMapper;
import kg.mozgohack.goodoc.repository.MedicineTypeRepository;
import kg.mozgohack.goodoc.repository.TakeTimeDayRepository;
import kg.mozgohack.goodoc.repository.TakeTimeRepository;
import kg.mozgohack.goodoc.repository.UserRepository;
import kg.mozgohack.goodoc.service.MedicineService;
import kg.mozgohack.goodoc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService {
    private final MedicineTypeRepository medicineTypeRepository;
    private final MedicineTypeMapper medicineTypeMapper;
    private final TakeTimeMapper takeTimeMapper;
    private final TakeTimeDayRepository takeTimeDayRepository;
    private final UserService userService;
    private final TakeTimeRepository takeTimeRepository;
    private final UserRepository userRepository;
    @Override
    public List<MedicineTypeResponse> getAllMedicineTypes() {
        return medicineTypeMapper.toDtoS(medicineTypeRepository.findAll());
    }

    @Override
    public List<TakeTimeDaysResponse> getAllTakeTimeDays() {
        return takeTimeMapper.toDtoS(takeTimeDayRepository.findAll());
    }

    @Override
    public void addMedicine(String token, MedicineRequest request) {
        User user = userService.getUsernameFromToken(token);
        Medicine medicine = new Medicine();
        medicine.setName(request.getName());
        medicine.setType(getMedicineType(request.getMedicineTypeName()));
        medicine.setTakeTime(getTimeTake(request.getTakeTimeRequest()));
        medicine.setCount(request.getCount());
        List<Medicine> userMedicines = new ArrayList<>();
        if (!user.getMedicines().isEmpty())
            userMedicines = user.getMedicines();
        userMedicines.add(medicine);
        userRepository.save(user);
    }

    private TakeTime getTimeTake(TakeTimeRequest takeTimeRequest) {
        if (takeTimeDayRepository.findByName(takeTimeRequest.getName()).isEmpty())
            throw new NotFoundException("no day name with: "+ takeTimeRequest.getName(), HttpStatus.NOT_FOUND);
        TakeTime takeTime = new TakeTime();
        takeTime.setDay(takeTimeDayRepository.findByName(takeTimeRequest.getName()).get());
        takeTime.setCountDose(takeTimeRequest.getCountDose());
        takeTime.setFirstDoseTime(takeTime.getFirstDoseTime());
        return takeTimeRepository.save(takeTime);
    }


    private MedicineType getMedicineType(String medicineTypeName) {
        Optional<MedicineType> medicineType = medicineTypeRepository.findByName(medicineTypeName);
        if (medicineType.isEmpty())
            throw new NotFoundException("no medicine type with name: "+ medicineTypeName, HttpStatus.NOT_FOUND);
        return medicineType.get();
    }
}
