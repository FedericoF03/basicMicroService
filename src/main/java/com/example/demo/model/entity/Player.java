package com.example.demo.model.entity;

import jakarta.persistence.*;

// Este siempre va a ser el armado de la base de datos es como el template de una tabla con sus registros y campos y columnas.
@Entity
@Table
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer score;
    @Column
    private Long trainer_ID;
    @Column
    private String team;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Long getTrainer_ID() {
        return trainer_ID;
    }

    public void setTrainer_ID(Long trainer_ID) {
        this.trainer_ID = trainer_ID;
    }
    //    @ManyToOne
//    @JoinColumn(name = "trainer")
//    private TrainerEntity trainer;
//
//    public void setTrainer(TrainerEntity trainer) {
//        this.trainer = trainer;
//    }
//
//    public TrainerEntity getTrainerEntity() {
//        return trainer;
//    }

    public Player() {

    }

    public Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public Player(Long id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
