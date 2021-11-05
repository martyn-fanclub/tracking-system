package com.github.martynfunclub.trackingsystem.services;

import com.github.martynfunclub.trackingsystem.dto.DetailTypeDTO;
import com.github.martynfunclub.trackingsystem.models.DetailType;

import java.util.List;
import java.util.Optional;

public interface DetailTypeService {
    List<DetailType> findAll();
    boolean save(DetailTypeDTO detailTypeDTO);
    Optional<DetailType> findById(Long id);
    void deleteById(Long id);
}
