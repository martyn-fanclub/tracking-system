package com.github.martynfunclub.trackingsystem.services.impl;


import com.github.martynfunclub.trackingsystem.dto.DetailTypeDTO;
import com.github.martynfunclub.trackingsystem.models.DetailType;
import com.github.martynfunclub.trackingsystem.repositories.DetailTypeRepository;
import com.github.martynfunclub.trackingsystem.services.DetailTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class DetailTypeServiceImpl implements DetailTypeService {

    DetailTypeRepository detailTypeRepository;

    @Autowired
    public DetailTypeServiceImpl(DetailTypeRepository detailTypeRepository) {
        this.detailTypeRepository = detailTypeRepository;
    }

    @Override
    public List<DetailType> findAll() {
        return detailTypeRepository.findAll();
    }

    @Override
    public boolean save(DetailTypeDTO detailTypeDTO) {
        if (detailTypeRepository.findByName(detailTypeDTO.getName()) != null) {
            return false;
        }
        detailTypeRepository.save(new DetailType(detailTypeDTO.getName(), LocalTime.parse(detailTypeDTO.getMaxTime())));
        return true;
    }

    @Override
    public Optional<DetailType> findById(Long id) {
        return detailTypeRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        detailTypeRepository.deleteById(id);
    }
}
