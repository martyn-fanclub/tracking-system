package com.github.martynfunclub.trackingsystem.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.github.martynfunclub.trackingsystem.dto.ActionDTO;
import com.github.martynfunclub.trackingsystem.models.Action;
import com.github.martynfunclub.trackingsystem.models.ActionType;
import com.github.martynfunclub.trackingsystem.models.Shift;
import com.github.martynfunclub.trackingsystem.repositories.ActionRepository;
import com.github.martynfunclub.trackingsystem.repositories.ActionTypeRepository;
import com.github.martynfunclub.trackingsystem.repositories.ShiftRepository;
import com.github.martynfunclub.trackingsystem.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionServiceImpl implements ActionService {

    ActionRepository actionRepository;
    ShiftRepository shiftRepository;
    ActionTypeRepository actionTypeRepository;

    @Autowired
    public ActionServiceImpl(ActionRepository actionRepository, ShiftRepository shiftRepository,
                             ActionTypeRepository actionTypeRepository) {
        this.actionRepository = actionRepository;
        this.shiftRepository = shiftRepository;
        this.actionTypeRepository = actionTypeRepository;
    }

    @Override
    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    @Override
    public boolean createAction(ActionDTO actionDTO) {
        Optional<Shift> shift = shiftRepository.findById(actionDTO.getShiftID());
        Optional<ActionType> actionType = actionTypeRepository.findById(actionDTO.getActionTypeID());
        if (shift.isEmpty() || actionType.isEmpty()) {
            return false;
        }
        actionRepository.save(new Action(shift.get(), actionType.get(),
                LocalDateTime.now(), null, actionDTO.getComment()));
        return true;
    }

    @Override
    public Optional<Action> getAction(Long id) {
        return actionRepository.findById(id);
    }

    @Override
    public void deleteAction(Long id) {
        actionRepository.deleteById(id);
    }
}
