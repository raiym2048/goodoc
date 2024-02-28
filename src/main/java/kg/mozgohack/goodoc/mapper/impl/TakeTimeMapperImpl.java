package kg.mozgohack.goodoc.mapper.impl;

import kg.mozgohack.goodoc.dto.medicine.TakeTimeDaysResponse;
import kg.mozgohack.goodoc.entities.TakeTimeDay;
import kg.mozgohack.goodoc.mapper.TakeTimeMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TakeTimeMapperImpl implements TakeTimeMapper {
    @Override
    public List<TakeTimeDaysResponse> toDtoS(List<TakeTimeDay> all) {
        List<TakeTimeDaysResponse> responses = new ArrayList<>();
        for (TakeTimeDay takeTimeDay : all){
            responses.add(toDto(takeTimeDay));
        }
        return responses;
    }

    @Override
    public TakeTimeDaysResponse toDto(TakeTimeDay takeTimeDay) {
        TakeTimeDaysResponse response = new TakeTimeDaysResponse();
        response.setName(takeTimeDay.getName());
        return response;
    }
}
