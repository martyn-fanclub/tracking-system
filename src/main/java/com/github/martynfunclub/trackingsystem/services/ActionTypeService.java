package com.github.martynfunclub.trackingsystem.services;

import java.util.List;
import java.util.Optional;

import com.github.martynfunclub.trackingsystem.dto.ActionTypeDTO;
import com.github.martynfunclub.trackingsystem.models.ActionType;

public interface ActionTypeService {
    List<ActionType> getAllActionTypes();
    boolean createActionType(ActionTypeDTO actionTypeDTO);
    Optional<ActionType> getActionType(Long id);
    void deleteActionType(Long id);
}
