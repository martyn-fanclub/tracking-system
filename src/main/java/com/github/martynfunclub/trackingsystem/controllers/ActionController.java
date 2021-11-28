package com.github.martynfunclub.trackingsystem.controllers;

import com.github.martynfunclub.trackingsystem.dto.ActionDTO;
import com.github.martynfunclub.trackingsystem.models.ActionType;
import com.github.martynfunclub.trackingsystem.models.Production;
import com.github.martynfunclub.trackingsystem.repositories.ProductionRepository;
import com.github.martynfunclub.trackingsystem.services.impl.ActionServiceImpl;
import com.github.martynfunclub.trackingsystem.services.impl.ActionTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ActionController {

    ActionTypeServiceImpl actionTypeService;
    ActionServiceImpl actionService;
    ProductionRepository productionRepository;

    List<ActionType> actionTypes;
    Long currentPlace;

    @Autowired
    public ActionController(ActionTypeServiceImpl actionTypeService, ActionServiceImpl actionService,
                            ProductionRepository productionRepository) {
        this.actionTypeService = actionTypeService;
        this.actionService = actionService;
        this.productionRepository = productionRepository;
    }

    @GetMapping("{placeID}/actions")
    public String getActions(@PathVariable("placeID") Long placeID, Model model) {
        actionTypes = actionTypeService.getAllActionTypes();
        currentPlace = placeID;
        model.addAttribute("actionTypes", actionTypes);
        return "actions/actions";
    }

    @PostMapping("actions/{id}")
    public String createAction(@PathVariable("id") Long actionTypeID) {
        Optional<Production> productionOptional = productionRepository.findAll().stream().
                filter(prod -> prod.getShift().getPlace().getId().equals(currentPlace)).findAny();

        productionOptional.ifPresent(production ->
                actionService.createAction(new ActionDTO(actionTypeID, production.getId())));
        return "redirect:/";
    }

}
