package com.example.demo.service;


import com.example.demo.model.dto.RefereeDTO;

import java.util.List;


public interface RefereeService {
    RefereeDTO save(RefereeDTO refereeDTO);

    RefereeDTO findById(Long id);

    List<RefereeDTO> getAll();

    RefereeDTO updateById(RefereeDTO refereeDTO);

    void deleteById(Long id);
}
