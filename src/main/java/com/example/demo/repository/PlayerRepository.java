package com.example.demo.repository;

import com.example.demo.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Este se conecta a la base de datos siempre se indica con repository.

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
//    List<Player> findByTeam(String team);
}
