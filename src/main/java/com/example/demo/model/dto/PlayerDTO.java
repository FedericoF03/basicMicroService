package com.example.demo.model.dto;

// En este solo transformamos los datos por seguridad y para solo devolver lo que queremos devolverle al cliente.
public class PlayerDTO {
    private Long id;
    private String name;
    private Integer score;
    private String team;

    public PlayerDTO() {

    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public PlayerDTO(String name, Integer score) {
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
