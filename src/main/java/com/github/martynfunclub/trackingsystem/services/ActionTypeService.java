package com.github.martynfunclub.trackingsystem.services;

import com.github.martynfunclub.trackingsystem.dto.ActionTypeDTO;
import com.github.martynfunclub.trackingsystem.models.ActionType;

import java.util.List;
import java.util.Optional;

public interface ActionTypeService {
    List<ActionType> getAllActionTypes();

    boolean createActionType(ActionTypeDTO actionTypeDTO);

    Optional<ActionType> getActionType(Long id);

    void deleteActionType(Long id);
}
