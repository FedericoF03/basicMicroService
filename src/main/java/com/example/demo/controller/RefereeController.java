package com.example.demo.controller;

import com.example.demo.model.dto.RefereeDTO;
import com.example.demo.model.res.RefereeResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/referee")
public class RefereeController {

    public final RefereeResponse refereeResponse;

    @Autowired
    public RefereeController(RefereeResponse refereeResponse) {
        this.refereeResponse = refereeResponse;
    }


    @GetMapping("/{id}")
    public RefereeDTO getReferee(@PathVariable Long id) {
        return refereeResponse.refereeService.findById(id);
    }

    @GetMapping()
    public List<RefereeDTO> getAllReferee() {
        return refereeResponse.refereeService.getAll();
    }

    @PostMapping("/v1/create")
    public RefereeDTO createReferee(@RequestBody RefereeDTO refereeDTO) {
        return refereeResponse.refereeService.save(refereeDTO);
    }

    @PutMapping("/{id}")
    public RefereeDTO putReferee(@PathVariable Long id, @RequestBody RefereeDTO refereeDTO) {
        refereeDTO.setId(id);
        return refereeResponse.refereeService.updateById(refereeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteReferee(@PathVariable Long id) {
        refereeResponse.refereeService.deleteById(id);
    }
}
