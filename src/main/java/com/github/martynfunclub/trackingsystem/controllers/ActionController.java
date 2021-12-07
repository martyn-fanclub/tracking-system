package com.github.martynfunclub.trackingsystem.controllers;

import java.util.Optional;

import com.github.martynfunclub.trackingsystem.dto.ActionDTO;
import com.github.martynfunclub.trackingsystem.models.Shift;
import com.github.martynfunclub.trackingsystem.repositories.ShiftRepository;
import com.github.martynfunclub.trackingsystem.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class ActionController {
    ActionService actionService;
    ShiftRepository shiftRepository;

    @Autowired
    public ActionController(ActionService actionService,
                            ShiftRepository shiftRepository) {
        this.actionService = actionService;
        this.shiftRepository = shiftRepository;
    }

    @PostMapping("/actions")
    public String createAction(@RequestParam("placeID") Long placeID,
                               @RequestParam("actionTypeID") Long actionTypeID) {
        Optional<Shift> shiftOptional = shiftRepository.findAll().stream().
                filter(shift -> shift.getPlace().getId().equals(placeID)).findAny();
        shiftOptional.ifPresent(shift ->
                actionService.createAction(new ActionDTO("", actionTypeID, shift.getId()))
        );
        return "redirect:/";
    }
}
