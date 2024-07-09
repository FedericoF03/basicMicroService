package com.example.demo.utils;

import com.example.demo.model.dto.PlayerDTO;
import com.example.demo.model.entity.Player;

public interface PlayerMapper {
    PlayerDTO toDto(Player player);

    Player toEntity(PlayerDTO playerDTO);
}
