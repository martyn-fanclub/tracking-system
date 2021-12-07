package com.github.martynfunclub.trackingsystem.services;

import java.util.List;
import java.util.Optional;

import com.github.martynfunclub.trackingsystem.models.Detail;

public interface DetailService {
    List<Detail> findAll();
    boolean save(long id);
    Optional<Detail> findById(Long id);
    boolean updateByOrderId(Long id);
}
