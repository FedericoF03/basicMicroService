package com.example.demo.utils;

import com.example.demo.model.dto.TrainerDTO;
import com.example.demo.model.entity.TrainerEntity;

public interface TrainerMapper {
    TrainerEntity toEntity(TrainerDTO trainerDTO);

    TrainerDTO toDTO(TrainerEntity trainerEntity);
}
