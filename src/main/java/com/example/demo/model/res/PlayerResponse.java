package com.example.demo.model.res;

import org.springframework.stereotype.Component;

@Component
public class PlayerResponse {
    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
