package com.github.martynfunclub.trackingsystem.services.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.martynfunclub.trackingsystem.models.Detail;
import com.github.martynfunclub.trackingsystem.models.DetailType;
import com.github.martynfunclub.trackingsystem.repositories.DetailRepository;
import com.github.martynfunclub.trackingsystem.services.DetailService;
import com.github.martynfunclub.trackingsystem.services.DetailTypeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DetailServiceImpl implements DetailService {
    DetailRepository detailRepository;
    DetailTypeService detailTypeService;

    @Override
    public List<Detail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public boolean save(long id) {
        Optional<DetailType> detailType = detailTypeService.findById(id);
        if (detailType.isEmpty()) {
            return false;
        }
        detailRepository.save(new Detail(detailType.get()));
        return true;
}

    @Override
    public Optional<Detail> findById(Long id) {
        return detailRepository.findById(id);
    }
}
