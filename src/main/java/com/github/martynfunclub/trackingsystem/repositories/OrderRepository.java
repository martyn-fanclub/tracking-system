package com.github.martynfunclub.trackingsystem.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.martynfunclub.trackingsystem.models.Order;
import com.github.martynfunclub.trackingsystem.models.OrderType;
import com.github.martynfunclub.trackingsystem.models.Status;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Set<Order> findByOrderTypeInAndStatusIsOrderByPriorityDesc(Set<OrderType> orderTypes, Status status);
}