package com.github.martynfunclub.trackingsystem.services.impl;

import com.github.martynfunclub.trackingsystem.dto.ActionDTO;
import com.github.martynfunclub.trackingsystem.models.Action;
import com.github.martynfunclub.trackingsystem.models.ActionType;
import com.github.martynfunclub.trackingsystem.models.Production;
import com.github.martynfunclub.trackingsystem.repositories.ActionRepository;
import com.github.martynfunclub.trackingsystem.repositories.ActionTypeRepository;
import com.github.martynfunclub.trackingsystem.repositories.ProductionRepository;
import com.github.martynfunclub.trackingsystem.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ActionServiceImpl implements ActionService {

    ActionRepository actionRepository;
    ProductionRepository productionRepository;
    ActionTypeRepository actionTypeRepository;

    @Autowired
    public ActionServiceImpl(ActionRepository actionRepository, ProductionRepository productionRepository,
                             ActionTypeRepository actionTypeRepository) {
        this.actionRepository = actionRepository;
        this.productionRepository = productionRepository;
        this.actionTypeRepository = actionTypeRepository;
    }

    @Override
    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    @Override
    public boolean createAction(ActionDTO actionDTO) {
        Optional<Production> production = productionRepository.findById(actionDTO.getProductionID());
        Optional<ActionType> actionType = actionTypeRepository.findById(actionDTO.getActionTypeID());
        if (production.isEmpty() || actionType.isEmpty()) {
            return false;
        }
        actionRepository.save(new Action(String.valueOf(LocalDateTime.now()), production.get(), actionType.get()));
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
