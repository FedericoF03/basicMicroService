package com.example.demo.utils.impl;

import com.example.demo.model.dto.PlayerDTO;
import com.example.demo.model.entity.Player;
import com.example.demo.utils.PlayerMapper;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public PlayerDTO toDto(Player clientEntity) {
        if (clientEntity == null) {
            return null;
        }
        PlayerDTO ret = new PlayerDTO();

        ret.setId(clientEntity.getId());
        ret.setName(clientEntity.getName());
        ret.setScore(clientEntity.getScore());
        ret.setTeam(clientEntity.getTeam());
        return ret;
    }

    @Override
    public Player toEntity(PlayerDTO clientDto) {
        if (clientDto == null) {
            return null;
        }
        Player ret = new Player();
        ret.setId(clientDto.getId());
        ret.setName(clientDto.getName());
        ret.setScore(clientDto.getScore());
        ret.setTeam(clientDto.getTeam());
        return ret;
    }
}
