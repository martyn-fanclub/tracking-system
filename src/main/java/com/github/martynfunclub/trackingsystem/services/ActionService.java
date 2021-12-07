package com.github.martynfunclub.trackingsystem.services;

import com.github.martynfunclub.trackingsystem.dto.ActionDTO;
import com.github.martynfunclub.trackingsystem.models.Action;

import java.util.List;
import java.util.Optional;

public interface ActionService {
    List<Action> getAllActions();
    boolean createAction(ActionDTO actionDTO);
    Optional<Action> getAction(Long id);
    void deleteAction(Long id);
}
