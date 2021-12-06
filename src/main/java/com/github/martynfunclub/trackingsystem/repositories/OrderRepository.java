package com.github.martynfunclub.trackingsystem.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.martynfunclub.trackingsystem.models.Order;
import com.github.martynfunclub.trackingsystem.models.OrderType;
import com.github.martynfunclub.trackingsystem.models.Status;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Set<Order> findByOrderTypeInAndStatusIsOrderByPriorityDesc(Set<OrderType> orderTypes, Status status);

    @Query(value = "SELECT * FROM order_types " +
            "LEFT JOIN order_types_orders ON (order_types.id = order_types_orders.order_type_id) " +
            "LEFT JOIN orders ON (order_types_orders.order_type_id = orders.order_type_id) " +
            "LEFT JOIN productions ON (orders.order_type_id = productions.order_id) " +
            "WHERE orders.STATUS='PENDING' ORDER BY ORDERS.PRIORITY", nativeQuery = true)
    List<Order> findByPlaceAndStatusIsOrderByPriority(@Param("id") Long placeId);
}
