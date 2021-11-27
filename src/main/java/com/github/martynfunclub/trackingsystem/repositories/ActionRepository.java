package com.github.martynfunclub.trackingsystem.repositories;

import com.github.martynfunclub.trackingsystem.models.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.martynfunclub.trackingsystem.models.Production;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
}
