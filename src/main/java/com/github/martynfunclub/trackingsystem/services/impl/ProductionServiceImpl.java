package com.github.martynfunclub.trackingsystem.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.martynfunclub.trackingsystem.models.Order;
import com.github.martynfunclub.trackingsystem.models.Production;
import com.github.martynfunclub.trackingsystem.models.Shift;
import com.github.martynfunclub.trackingsystem.models.Status;
import com.github.martynfunclub.trackingsystem.repositories.OrderRepository;
import com.github.martynfunclub.trackingsystem.repositories.ProductionRepository;
import com.github.martynfunclub.trackingsystem.repositories.ShiftRepository;
import com.github.martynfunclub.trackingsystem.services.DetailService;
import com.github.martynfunclub.trackingsystem.services.ProductionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductionServiceImpl implements ProductionService {
    ProductionRepository productionRepository;
    ShiftRepository shiftRepository;
    OrderRepository orderRepository;
    DetailService detailService;

    @Override
    public boolean save(Long placeId) {
        Shift shift = shiftRepository.getShiftByPlaceIdAndEndTimeIsNull(placeId);
        List<Order> orders = orderRepository.findByPlaceAndStatusIsOrderByPriority(placeId);
        if (shift != null && !orders.isEmpty()) {
            Order order = orders.get(0);
            order.setStatus(Status.ACTIVE);
            productionRepository.save(new Production(shift, LocalDateTime.now(), null, order));
            return detailService.updateByOrderId(order.getId());
        }
        return false;
    }
}
