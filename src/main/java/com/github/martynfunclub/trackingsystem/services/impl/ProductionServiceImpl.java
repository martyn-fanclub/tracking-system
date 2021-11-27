package com.github.martynfunclub.trackingsystem.services.impl;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.martynfunclub.trackingsystem.models.Production;
import com.github.martynfunclub.trackingsystem.models.Shift;
import com.github.martynfunclub.trackingsystem.repositories.PlaceRepository;
import com.github.martynfunclub.trackingsystem.repositories.ProductionRepository;
import com.github.martynfunclub.trackingsystem.services.ProductionService;

@Service
public class ProductionServiceImpl implements ProductionService {
    ProductionRepository productionRepository;
    PlaceRepository placeRepository;

    @Autowired
    public ProductionServiceImpl(ProductionRepository productionRepository, PlaceRepository placeRepository) {
        this.productionRepository = productionRepository;
        this.placeRepository = placeRepository;
    }


    public Production findByWorkersPlaceId(Long id) {
        Collection<Shift> collection =
                new HashSet<>(placeRepository.getById(id).getShifts());
        for (Shift shift : collection) {
            Optional<Production> production =
                    shift.getProductions().stream()
                            .filter(prod -> prod.getEndTime() == null).findFirst();
            if (production.isPresent()) {
                return production.get();
            }
        }
        return null;
    }

    @Override
    public void save(Long id) {
        Production production = findByWorkersPlaceId(id);
        if (production == null) {
            return;
        }
        production.setEndTime(LocalDateTime.now());
        productionRepository.save(production);
    }
}
