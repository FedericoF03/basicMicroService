package com.example.demo.service;

import com.example.demo.model.dto.TrainerDTO;

import java.util.List;

public interface TrainerService {
    List<TrainerDTO> allTrainers();

    TrainerDTO putTrainer(TrainerDTO trainerDTO);

    TrainerDTO saveTrainer(TrainerDTO trainerDTO);

    TrainerDTO getTrainerByID(Long id);

    void deleteTrainer(Long id);
}
