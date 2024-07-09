package com.example.demo.service.impl;

import com.example.demo.model.dto.PlayerDTO;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.service.PlayerService;
import com.example.demo.utils.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

//Logica en el lugar incorrecto para mas informacion ir a src/main/java/com.example.demo/service/PlayerService.java

//public interface PlayerServiceImpl {
//    PlayerDTO savePlayer(PlayerDTO playerDTO);
//}

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerDTO save(PlayerDTO playerDTO) {

        if (playerDTO == null || playerDTO.getId() != null) {
            throw new IllegalArgumentException("El cliente no debe tener id y no debe ser null");
        }
        return this.playerMapper.toDto(this.playerRepository.save(this.playerMapper.toEntity(playerDTO)));
    }

    @Override
    public PlayerDTO findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no debe ser null");
        }
        return this.playerMapper.toDto(this.playerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No se encontro un cliente con esa id")));
    }

    @Override
    public List<PlayerDTO> findAll() {
        return this.playerRepository.findAll().stream().map(this.playerMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no debe ser null");
        }
        this.playerRepository.deleteById(id);
    }

    @Override
    public PlayerDTO put(PlayerDTO clientDto) {
        if (clientDto == null || clientDto.getId() == null) {
            throw new IllegalArgumentException("El cliente y su id no deben ser null");
        }

        if (!this.playerRepository.existsById(clientDto.getId())) {
            throw new NoSuchElementException("No existe un cliente con esa id");
        }

        return this.playerMapper.toDto(this.playerRepository.save(this.playerMapper.toEntity(clientDto)));
    }
}
