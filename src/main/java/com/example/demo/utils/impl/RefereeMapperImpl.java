package com.example.demo.utils.impl;

import com.example.demo.model.dto.RefereeDTO;
import com.example.demo.model.entity.Referee;
import com.example.demo.utils.RefereeMapper;
import org.springframework.stereotype.Component;

@Component
public class RefereeMapperImpl implements RefereeMapper {

    @Override
    public RefereeDTO toDto(Referee refereeEntity) {
        if (refereeEntity == null) {
            return null;
        }
        final RefereeDTO ret = new RefereeDTO();
        ret.setId(refereeEntity.getId());
        ret.setName(refereeEntity.getName());
        ret.setCountry(refereeEntity.getCountry());
        ret.setDisponibility(refereeEntity.getDisponibility());
        return ret;
    }

    @Override
    public Referee toEntity(RefereeDTO refereeDTO) {
        if (refereeDTO == null) {
            return null;
        }
        final Referee ret = new Referee();
        ret.setId(refereeDTO.getId());
        ret.setName(refereeDTO.getName());
        ret.setCountry(refereeDTO.getCountry());
        ret.setDisponibility(refereeDTO.getDisponibility());
        return ret;
    }
}
