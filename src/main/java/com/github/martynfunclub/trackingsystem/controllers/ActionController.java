package com.github.martynfunclub.trackingsystem.controllers;

import com.github.martynfunclub.trackingsystem.dto.ActionDTO;
import com.github.martynfunclub.trackingsystem.models.ActionType;
import com.github.martynfunclub.trackingsystem.services.ActionService;
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

@Controller
@RequestMapping
public class ActionController {

    ActionTypeServiceImpl actionTypeService;
    ActionServiceImpl actionService;

    List<ActionType> actionTypes;
    Long currentProduction;

    @Autowired
    public ActionController(ActionTypeServiceImpl actionTypeService, ActionServiceImpl actionService) {
        this.actionTypeService = actionTypeService;
        this.actionService = actionService;
    }

    @GetMapping("{productionID}/actions")
    public String getActions(@PathVariable("productionID") Long productionID, Model model) {
        actionTypes = actionTypeService.getAllActionTypes();
        currentProduction = productionID;
        model.addAttribute("actionTypes", actionTypes);
        return "actions/actions";
    }

    @PostMapping("actions/{id}")
    public String createAction(@PathVariable("id") Long actionTypeID) {
        actionService.createAction(new ActionDTO(actionTypeID, currentProduction));
        return "redirect:/";
    }

}
