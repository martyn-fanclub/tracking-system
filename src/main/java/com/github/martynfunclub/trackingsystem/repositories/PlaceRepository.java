package com.github.martynfunclub.trackingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.martynfunclub.trackingsystem.models.WorkersPlace;

public interface PlaceRepository extends JpaRepository<WorkersPlace, Long> {
    WorkersPlace getPlaceByName(String string);
}
