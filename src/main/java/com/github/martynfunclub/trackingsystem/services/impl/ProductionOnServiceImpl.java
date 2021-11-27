package com.github.martynfunclub.trackingsystem.services.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.martynfunclub.trackingsystem.models.Production;
import com.github.martynfunclub.trackingsystem.models.Shift;
import com.github.martynfunclub.trackingsystem.repositories.PlaceRepository;
import com.github.martynfunclub.trackingsystem.repositories.ProductionRepository;
import com.github.martynfunclub.trackingsystem.services.ProductionOnService;

@Service
public class ProductionOnServiceImpl implements ProductionOnService {
    ProductionRepository productionRepository;
    PlaceRepository placeRepository;

    @Autowired
    public ProductionOnServiceImpl(ProductionRepository productionRepository, PlaceRepository placeRepository) {
        this.productionRepository = productionRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean save(Long id) {
        Optional<Shift> shift = placeRepository.getById(id).getShifts().stream()
                .filter(shiftInSet -> shiftInSet.getStartTime().isBefore(LocalDateTime.now()) && (shiftInSet.getEndTime() == null))
                .findFirst();
        if (shift.isPresent()) {
            Production production = new Production(shift.get(), LocalDateTime.now(), null, null);
            productionRepository.save(production);
            return true;
        }
        return false;
    }
}
