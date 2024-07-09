package com.example.demo.model.res;

import com.example.demo.service.RefereeService;
import org.springframework.stereotype.Component;

@Component
public class RefereeResponse {
    public final RefereeService refereeService;
    public Integer status;

    public RefereeResponse(RefereeService refereeService) {
        this.refereeService = refereeService;
        this.status = null;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public RefereeService getRefereeService() {
        return refereeService;
    }

    public RefereeResponse getRefereeResponse() {
        return this;
    }
}
