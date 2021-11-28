package com.github.martynfunclub.trackingsystem.services.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.martynfunclub.trackingsystem.models.Production;
import com.github.martynfunclub.trackingsystem.repositories.ProductionRepository;
import com.github.martynfunclub.trackingsystem.repositories.ShiftRepository;
import com.github.martynfunclub.trackingsystem.services.ProductionService;

@Service
public class ProductionServiceImpl implements ProductionService {
    ProductionRepository productionRepository;
    ShiftRepository shiftRepository;

    @Autowired
    public ProductionServiceImpl(ProductionRepository productionRepository, ShiftRepository shiftRepository) {
        this.productionRepository = productionRepository;
        this.shiftRepository = shiftRepository;
    }

    @Override
    public void updateEndTime(@RequestParam Long id) {
        Production production =
                productionRepository.getProductionByShiftAndEndTimeIsNull(shiftRepository.getByPlaceId(id));
        if (production != null) {
            production.setEndTime(LocalDateTime.now());
            productionRepository.save(production);
        }
    }
}
