package com.github.martynfunclub.trackingsystem.services.impl;

import com.github.martynfunclub.trackingsystem.models.Detail;
import com.github.martynfunclub.trackingsystem.models.DetailType;
import com.github.martynfunclub.trackingsystem.repositories.DetailRepository;
import com.github.martynfunclub.trackingsystem.services.DetailService;
import com.github.martynfunclub.trackingsystem.services.DetailTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DetailServiceImpl implements DetailService {

    DetailRepository detailRepository;
    @Autowired
    DetailTypeService detailTypeService;

    @Autowired
    public DetailServiceImpl(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Override
    public List<Detail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public boolean save(long id) {
        try {
            Optional<DetailType> detailType = detailTypeService.findById(id);
            detailRepository.save(new Detail(detailType.get()));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public Optional<Detail> findById(Long id) {
        return detailRepository.findById(id);
    }

}
