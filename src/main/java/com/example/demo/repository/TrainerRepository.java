package com.example.demo.repository;

import com.example.demo.model.entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrainerRepository extends JpaRepository<TrainerEntity, Long> {
}
