package com.example.demo.utils.impl;


import com.example.demo.model.dto.TrainerDTO;
import com.example.demo.model.entity.TrainerEntity;
import com.example.demo.utils.PlayerMapper;
import com.example.demo.utils.TrainerMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainerMapperImpl implements TrainerMapper {

    private final PlayerMapper playerMapper;

    public TrainerMapperImpl(PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }

    @Override
    public TrainerEntity toEntity(TrainerDTO trainerDTO) {
        if (trainerDTO == null) throw new IllegalArgumentException("El trainerDTO esta vacio.");

        final TrainerEntity ret = new TrainerEntity();
//        if (trainerDTO.getPlayers() != null)
        ret.setPlayers(trainerDTO.getPlayers().stream().map(playerMapper::toEntity).toList());
        ret.setCountry(trainerDTO.getCountry());
        ret.setName(trainerDTO.getName());
        ret.setId(trainerDTO.getId());
        ret.setTeam(trainerDTO.getTeam());
        return ret;
    }

    @Override
    public TrainerDTO toDTO(TrainerEntity trainerEntity) {
        if (trainerEntity == null) throw new IllegalArgumentException("El trainerDTO esta vacio.");

        final TrainerDTO ret = new TrainerDTO();
//        if (trainerEntity.getPlayers() != null)
        ret.setPlayers(trainerEntity.getPlayers().stream().map(playerMapper::toDto).toList());
        ret.setCountry(trainerEntity.getCountry());
        ret.setName(trainerEntity.getName());
        ret.setId(trainerEntity.getId());
        ret.setTeam(trainerEntity.getTeam());
        return ret;
    }
}
