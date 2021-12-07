package com.github.martynfunclub.trackingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.martynfunclub.trackingsystem.models.Detail;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

    @Query(value = "Select * from details " +
            "join detail_types dt on details.detail_type_id=dt.id " +
            "join order_types ot on ot.from_id = dt.id " +
            "join orders o on o.order_type_id = ot.id " +
            "where o.id =:id and details.is_taken != true", nativeQuery = true)
    Detail findByOrderId(@Param("id") Long id);
}
