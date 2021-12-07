package com.github.martynfunclub.trackingsystem.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.martynfunclub.trackingsystem.models.Order;
import com.github.martynfunclub.trackingsystem.models.OrderType;
import com.github.martynfunclub.trackingsystem.models.Status;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Set<Order> findByOrderTypeInAndStatusIsOrderByPriorityDesc(Set<OrderType> orderTypes, Status status);

    @Query(value = "SELECT * FROM orders " +
            "join order_types ot " +
            "join order_types_places otp " +
            "join workers_place wp " +
            "where orders.status = 'PENDING' and wp.id = :id  ORDER BY orders.priority", nativeQuery = true)
    List<Order> findByPlaceAndStatusIsOrderByPriority(@Param("id") Long placeId);
}
