package com.github.martynfunclub.trackingsystem.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.martynfunclub.trackingsystem.models.Order;
import com.github.martynfunclub.trackingsystem.models.Production;
import com.github.martynfunclub.trackingsystem.models.Shift;
import com.github.martynfunclub.trackingsystem.repositories.OrderRepository;
import com.github.martynfunclub.trackingsystem.repositories.ProductionRepository;
import com.github.martynfunclub.trackingsystem.repositories.ShiftRepository;
import com.github.martynfunclub.trackingsystem.services.ProductionService;

@Service
public class ProductionServiceImpl implements ProductionService {
    ProductionRepository productionRepository;
    ShiftRepository shiftRepository;
    OrderRepository orderRepository;

    @Autowired
    public ProductionServiceImpl(ProductionRepository productionRepository, ShiftRepository shiftRepository, OrderRepository orderRepository) {
        this.productionRepository = productionRepository;
        this.shiftRepository = shiftRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean save(Long placeId) {
        Shift shift = shiftRepository.getShiftByPlaceIdAndEndTimeIsNull(placeId);
        List<Order> orders = orderRepository.findByPlaceAndStatusIsOrderByPriority(placeId);
        if (shift != null && !orders.isEmpty()) {
            productionRepository.save(new Production(shift, LocalDateTime.now(), null, orders.get(0)));
            return true;
        }
        return false;
    }
}
