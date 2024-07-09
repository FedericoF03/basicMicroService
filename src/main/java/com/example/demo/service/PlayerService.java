package com.example.demo.service;

import com.example.demo.model.dto.PlayerDTO;

import java.util.List;


/* Errores:
    -Esto no es logica de negocio esto deberia ser la interface, la carpeta impl tendria que llevar esto.
    Lo que deberia ir aca son los metodos pero vacios para aplicarlos.
    -No es el service esta es la interfaz o tambien dicho es el contrato lo que tiene que tener la clase que herede que seria implements
    -Se repite el error de controller de invocar directamente. (Yo creo: Como mencione anteriormente mi error es no haber usado el Autowired en todas las capaz)
*/

// Este es la logica de negocio
/*
@Service
public class PlayerService implements PlayerServiceImpl {

    private PlayerMapper playerMapper;
    private PlayerRepository playerRepository;

    public PlayerService() {

    }

    @Autowired
    public PlayerService(PlayerMapper playerMapper, PlayerRepository playerRepository) {
        this.playerMapper = playerMapper;
        this.playerRepository = playerRepository;
    }


    @Override
    public PlayerDTO savePlayer(PlayerDTO playerDTO) {
        Player entityMapped = this.playerMapper.toEntity(playerDTO, new Player());
        return this.playerMapper.toDto(this.playerRepository.save(entityMapped), playerDTO);
    }

}
*/
public interface PlayerService {
    PlayerDTO save(PlayerDTO clientDto);

    PlayerDTO findById(Long id);

    List<PlayerDTO> findAll();

    void delete(Long id);

    PlayerDTO put(PlayerDTO clientDto);
}