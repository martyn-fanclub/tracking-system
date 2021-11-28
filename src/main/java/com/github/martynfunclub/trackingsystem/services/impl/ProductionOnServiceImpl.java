package com.github.martynfunclub.trackingsystem.services.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.martynfunclub.trackingsystem.models.Production;
import com.github.martynfunclub.trackingsystem.models.Shift;
import com.github.martynfunclub.trackingsystem.repositories.ProductionRepository;
import com.github.martynfunclub.trackingsystem.repositories.ShiftRepository;
import com.github.martynfunclub.trackingsystem.services.ProductionOnService;

@Service
public class ProductionOnServiceImpl implements ProductionOnService {
    ProductionRepository productionRepository;
    ShiftRepository shiftRepository;

    @Autowired
    public ProductionOnServiceImpl(ProductionRepository productionRepository, ShiftRepository shiftRepository) {
        this.productionRepository = productionRepository;
        this.shiftRepository = shiftRepository;
    }

    @Override
    public boolean save(Long placeId) {
        Optional<Shift> shift = shiftRepository.findByPlaceIdAndEndTimeIsNull(placeId);
        if (shift.isPresent()) {
            productionRepository.save(new Production(shift.get(), LocalDateTime.now(), null, null));
            return true;
        }
        return false;
    }
}
