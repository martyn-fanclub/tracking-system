package com.github.martynfunclub.trackingsystem.controllers;

import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.martynfunclub.trackingsystem.dto.ActionTypeDTO;
import com.github.martynfunclub.trackingsystem.models.ActionType;
import com.github.martynfunclub.trackingsystem.services.ActionTypeService;

@Controller
@RequestMapping
public class ActionTypeController {

    ActionTypeService actionTypeService;

    @Autowired
    public ActionTypeController(ActionTypeService actionTypeService) {
        this.actionTypeService = actionTypeService;
    }

    @GetMapping("/action-types")
    public String getActionTypes(Model model) {
        model.addAttribute("title", "Все действия");
        model.addAttribute("actionTypes", actionTypeService.getAllActionTypes());
        return "action-types/action-types";
    }

    @GetMapping("/action-types/{id}")
    public String getActionTypes(@PathVariable("id") Long id, Model model) {
        Optional<ActionType> actionType = actionTypeService.getActionType(id);
        if (actionType.isEmpty()) {
            return "errors/404";
        }
        model.addAttribute("title", actionType.get().getName());
        model.addAttribute("actionType", actionType.get());
        return "action-types/action-type";
    }

    @GetMapping("/action-types/form")
    public String actionTypeForm(Model model) {
        model.addAttribute("title", "Добавить новое действие");
        model.addAttribute("actionTypeForm", new ActionTypeDTO());
        return "action-types/create-action-type";
    }

    @PostMapping("/action-types")
    public String createActionType(@ModelAttribute("actionTypeForm") @Valid ActionTypeDTO actionTypeDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors() && actionTypeService.createActionType(actionTypeDTO)) {
            return "redirect:/";
        }
        return "redirect:/action-types/form?errors";
    }

    @PostMapping("/action-types/delete")
    public String getActionTypes(@RequestParam(name = "id") Long id) {
        try {
            actionTypeService.deleteActionType(id);
        } catch (EmptyResultDataAccessException ignored) {
        }
        return "redirect:/";
    }
}
