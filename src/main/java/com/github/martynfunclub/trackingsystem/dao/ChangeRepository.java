package com.github.martynfunclub.trackingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.martynfunclub.trackingsystem.models.Change;

@Repository
public interface ChangeRepository extends JpaRepository<Change, Long> {
}
