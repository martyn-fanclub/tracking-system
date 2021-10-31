package com.github.martynfunclub.trackingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.martynfunclub.trackingsystem.models.ActionType;

@Repository
public interface ActionTypeRepository extends JpaRepository<ActionType, Long> {
    ActionType findByName(String name);
}
