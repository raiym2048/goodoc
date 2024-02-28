package kg.mozgohack.goodoc.mapper;

import kg.mozgohack.goodoc.dto.medicine.TakeTimeDaysResponse;
import kg.mozgohack.goodoc.entities.TakeTimeDay;

import java.util.List;

public interface TakeTimeMapper {
    List<TakeTimeDaysResponse> toDtoS(List<TakeTimeDay> all);

    TakeTimeDaysResponse toDto(TakeTimeDay takeTimeDay);
}
