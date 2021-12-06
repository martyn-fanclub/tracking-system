package com.github.martynfunclub.trackingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.martynfunclub.trackingsystem.models.Production;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long> {
    @Query("select p from Production p " +
            "left join Shift s on p.shift = s " +
            "left join WorkersPlace wp on s.place = wp " +
            "where s.endTime is null and p.endTime is null and wp.id = :id")
    Production getProductionByPlaceId(@Param("id") Long workersPlaceId);
}
