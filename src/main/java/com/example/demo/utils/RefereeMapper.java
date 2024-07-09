package com.example.demo.utils;

import com.example.demo.model.dto.RefereeDTO;
import com.example.demo.model.entity.Referee;

public interface RefereeMapper {

    RefereeDTO toDto(Referee refereeEntity);

    Referee toEntity(RefereeDTO refereeDTO);
}
