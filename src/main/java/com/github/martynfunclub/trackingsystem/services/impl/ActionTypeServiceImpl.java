package com.github.martynfunclub.trackingsystem.services.impl;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.martynfunclub.trackingsystem.dto.ActionTypeDTO;
import com.github.martynfunclub.trackingsystem.models.ActionType;
import com.github.martynfunclub.trackingsystem.repositories.ActionTypeRepository;
import com.github.martynfunclub.trackingsystem.services.ActionTypeService;

@Service
public class ActionTypeServiceImpl implements ActionTypeService {

    ActionTypeRepository actionTypeRepository;

    @Autowired
    public ActionTypeServiceImpl(ActionTypeRepository actionTypeRepository) {
        this.actionTypeRepository = actionTypeRepository;
    }

    @Override
    public List<ActionType> getAllActionTypes() {
        return actionTypeRepository.findAll();
    }

    @Override
    public boolean createActionType(ActionTypeDTO actionTypeDTO) {
        if (actionTypeRepository.findByName(actionTypeDTO.getName()) != null) {
            return false;
        }
        actionTypeRepository.save(new ActionType(actionTypeDTO.getName(), LocalTime.parse(actionTypeDTO.getMaxTime())));
        return true;
    }

    @Override
    public Optional<ActionType> getActionType(Long id) {
        return actionTypeRepository.findById(id);
    }

    @Override
    public void deleteActionType(Long id) {
        actionTypeRepository.deleteById(id);
    }
}
