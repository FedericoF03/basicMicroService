package com.example.demo.service.impl;

import com.example.demo.model.dto.RefereeDTO;
import com.example.demo.repository.RefereeRepository;
import com.example.demo.service.RefereeService;
import com.example.demo.utils.RefereeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RefereeServiceImpl implements RefereeService {

    public final RefereeRepository refereeRepository;
    public final RefereeMapper refereeMapper;

    @Autowired
    RefereeServiceImpl(RefereeRepository refereeRepository, RefereeMapper refereeMapper) {
        this.refereeRepository = refereeRepository;
        this.refereeMapper = refereeMapper;
    }


    @Override
    public RefereeDTO findById(Long id) {
        if (id == null) throw new IllegalArgumentException("No se inserto Id.");
        return refereeMapper.toDto(refereeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No se encontro el referee.")));
    }

    @Override
    public List<RefereeDTO> getAll() {
        return this.refereeRepository.findAll().stream().map(this.refereeMapper::toDto).toList();
    }

    @Override
    public RefereeDTO save(RefereeDTO refereeDTO) {
        if (refereeDTO == null || refereeDTO.getId() != null)
            throw new IllegalArgumentException("El referee tiene ID o esta vacio.");
        return refereeMapper.toDto(refereeRepository.save(refereeMapper.toEntity(refereeDTO)));
    }

    @Override
    public RefereeDTO updateById(RefereeDTO refereeDTO) {
        if (refereeDTO == null) throw new IllegalArgumentException("falta referee");

        if (!refereeRepository.existsById(refereeDTO.getId()))
            throw new NoSuchElementException("No existe un cliente con esa id");
        return refereeMapper.toDto(refereeRepository.save(refereeMapper.toEntity(refereeDTO)));
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) throw new IllegalArgumentException("No se inserto el ID.");
        refereeRepository.deleteById(id);
    }


}
