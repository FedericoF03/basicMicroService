package com.example.demo.model.res;

import com.example.demo.service.TrainerService;
import org.springframework.stereotype.Component;

@Component
public class TrainerResponse {

    private final TrainerService trainerService;

    public TrainerResponse(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    public TrainerService getTrainerService() {
        return trainerService;
    }
}
