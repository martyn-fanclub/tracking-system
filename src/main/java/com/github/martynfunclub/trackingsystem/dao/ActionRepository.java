package com.github.martynfunclub.trackingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.martynfunclub.trackingsystem.models.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
}
