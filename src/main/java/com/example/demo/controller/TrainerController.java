package com.example.demo.controller;

import com.example.demo.model.dto.TrainerDTO;
import com.example.demo.model.res.TrainerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    private final TrainerResponse trainerResponse;


    @Autowired
    public TrainerController(TrainerResponse trainerResponse) {
        this.trainerResponse = trainerResponse;
    }

    @GetMapping
    public List<TrainerDTO> allTrainers() {
        return trainerResponse.getTrainerService().allTrainers();
    }

    @PostMapping("/v1/create")
    public TrainerDTO saveTrainer(@RequestBody TrainerDTO trainerDTO) {
        return trainerResponse.getTrainerService().saveTrainer(trainerDTO);
    }

    @GetMapping("/{id}")
    public TrainerDTO getTrainerById(@PathVariable Long id) {
        return trainerResponse.getTrainerService().getTrainerByID(id);
    }

    @PutMapping("/{id}")
    public TrainerDTO putTrainer(@PathVariable Long id, @RequestBody TrainerDTO trainerDTO) {
        trainerDTO.setId(id);
        return trainerResponse.getTrainerService().putTrainer(trainerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainer(@PathVariable Long id) {
        trainerResponse.getTrainerService().deleteTrainer(id);
    }


}
