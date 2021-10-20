package com.github.martynfunclub.trackingsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.martynfunclub.trackingsystem.dto.CredentialsDto;
import com.github.martynfunclub.trackingsystem.services.ChangesService;

@Controller
@RequestMapping("/changes")
public class ChangeController {

    private final ChangesService changesService;

    @Autowired
    public ChangeController(ChangesService changesService) {
        this.changesService = changesService;
    }

    @GetMapping
    public String getAllChanges() {
        return "";
    }

    @PostMapping
    public String createChange(@Valid CredentialsDto credentialsDto) {
        changesService.createChange(credentialsDto);
        return "";
    }

//    @GetMapping("/{id}")
//    public String getChangeById(@RequestParam(value = ))

}
