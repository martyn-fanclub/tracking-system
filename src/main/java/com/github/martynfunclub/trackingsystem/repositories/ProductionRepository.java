package com.github.martynfunclub.trackingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.martynfunclub.trackingsystem.models.Production;
import com.github.martynfunclub.trackingsystem.models.Shift;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long> {
    Production getProductionByShiftAndEndTimeIsNull(Shift shift);
}
