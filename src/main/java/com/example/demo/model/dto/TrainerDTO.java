package com.example.demo.model.dto;


import java.util.List;

public class TrainerDTO {

    private Long id;
    private String name;
    private String country;
    private String team;

    private List<PlayerDTO> players;

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
