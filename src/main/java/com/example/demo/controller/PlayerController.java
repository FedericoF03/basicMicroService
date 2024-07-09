package com.example.demo.controller;

import com.example.demo.model.dto.PlayerDTO;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Este se encarga de controlar las rutas REST.
@RestController
@RequestMapping("/player")
public class PlayerController {

   /* @PostMapping(value = "/v1/create")
    public PlayerDTO postPlayer(@RequestBody Integer score, @RequestBody String name) {
        return new PlayerResponse().getResponse().savePlayer(playerDTO);
    }*/

    /* Errores:
        -Viole los principios de capa pues use invocaciones haciendolo de alto acoplamiento antes de usar una variable que haga
        referencia a la clase. (Yo creo: Cuando se usa se tiene que aplicar en todas las capas para no tener que declarar nada especificamente.)
        Mal uso principal de RequestBody por no saber como funcionaba.

    */
    public final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(value = "/v1/create")
    public PlayerDTO postPlayer(@RequestBody PlayerDTO playerDTO) {
        return this.playerService.save(playerDTO);
    }

    @GetMapping("/{id}")
    public PlayerDTO findById(@PathVariable Long id) {
        return this.playerService.findById(id);
    }

    @GetMapping
    public List<PlayerDTO> getAll() {
        return this.playerService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.playerService.delete(id);
    }

    @PutMapping("/{id}")
    public PlayerDTO update(@PathVariable Long id, @RequestBody PlayerDTO client) {
        client.setId(id);
        return this.playerService.put(client);
    }
}
