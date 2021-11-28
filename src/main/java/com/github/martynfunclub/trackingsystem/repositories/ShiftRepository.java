package com.github.martynfunclub.trackingsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.martynfunclub.trackingsystem.models.Shift;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
    Optional<Shift> findByPlaceIdAndEndTimeIsNull(Long id);
}