package com.github.martynfunclub.trackingsystem.services.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.martynfunclub.trackingsystem.models.Production;
import com.github.martynfunclub.trackingsystem.repositories.ProductionRepository;
import com.github.martynfunclub.trackingsystem.services.ProductionService;

@Service
public class ProductionServiceImpl implements ProductionService {
    ProductionRepository productionRepository;

    @Autowired
    public ProductionServiceImpl(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    @Override
    public boolean save(Long id) {
        Production production = productionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("student with id  does not exists"));
        production.setEndTime(LocalDateTime.now());
        productionRepository.save(production);
        return true;

    }
}
