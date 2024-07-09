package com.example.demo.service.impl;

import com.example.demo.model.dto.TrainerDTO;
import com.example.demo.model.entity.Player;
import com.example.demo.model.entity.TrainerEntity;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.TrainerRepository;
import com.example.demo.service.TrainerService;
import com.example.demo.utils.TrainerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    private final TrainerMapper trainerMapper;
    private final TrainerRepository trainerRepository;
    private final PlayerRepository playerRepository;

    public TrainerServiceImpl(TrainerMapper trainerMapper, TrainerRepository trainerRepository, PlayerRepository playerRepository) {
        this.trainerMapper = trainerMapper;
        this.trainerRepository = trainerRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public List<TrainerDTO> allTrainers() {
        return trainerRepository.findAll().stream().map(trainerMapper::toDTO).toList();
    }

    @Override
    public TrainerDTO putTrainer(TrainerDTO trainerDTO) {
        if (trainerDTO == null || trainerRepository.findById(trainerDTO.getId()).isEmpty())
            throw new IllegalArgumentException("El entrenador es nulo o no existe, reintentar.");
        // logica donde yo seteo la lista segun mi logica
//        TrainerEntity ret = trainerMapper.toEntity(trainerDTO);
//        ret.setListPlayer(playerRepository.findAll());
        return trainerMapper.toDTO(trainerRepository.save(trainerMapper.toEntity(trainerDTO)));
    }

    @Override
    public TrainerDTO saveTrainer(TrainerDTO trainerDTO) {
        if (trainerDTO == null || trainerDTO.getId() != null)
            throw new IllegalArgumentException("El entrenador tiene ID o es nulo, reintentar.");
        // logica donde yo seteo la lista segun mi logica
//        TrainerEntity ret = trainerMapper.toEntity(trainerDTO);
//        String gettingTeam = ret.getTeam();
//        List<Player> findingTeam = playerRepository.findByTeam(gettingTeam);
//        ret.setPlayers(findingTeam);
        return trainerMapper.toDTO(trainerRepository.save(trainerMapper.toEntity(trainerDTO)));
    }

    @Override
    public TrainerDTO getTrainerByID(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Por favor ingrese ID");
        return trainerMapper.toDTO(trainerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se encontro el usuario con ese ID")));
    }

    @Override
    public void deleteTrainer(Long id) {
        if (id == null || trainerRepository.findById(id).isEmpty())
            throw new IllegalArgumentException("el ID es nulo o el usuario no existe.");
        trainerRepository.deleteById(id);
    }
}
