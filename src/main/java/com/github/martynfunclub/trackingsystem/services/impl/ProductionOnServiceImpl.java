package com.github.martynfunclub.trackingsystem.services.impl;

import java.time.LocalDateTime;
import java.util.List;

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
        if (placeId == null) {
            return false;
        }
        List<Shift> shifts = shiftRepository.findByPlaceIdAndEndTimeIsNull(placeId);
        if (shifts.isEmpty()) {
            return false;
        }
        productionRepository.save(new Production(shifts.get(0), LocalDateTime.now(), null, null));
        return true;
    }
}
