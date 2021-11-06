package com.github.martynfunclub.trackingsystem.services;

import com.github.martynfunclub.trackingsystem.models.Detail;

import java.util.List;
import java.util.Optional;

public interface DetailService {
    List<Detail> findAll();
    boolean save(long id);
    Optional<Detail> findById(Long id);
}
