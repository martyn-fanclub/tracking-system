package com.github.martynfunclub.trackingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.martynfunclub.trackingsystem.models.User;
import com.github.martynfunclub.trackingsystem.repositories.UserRepository;

@Controller
public class MainController {

    UserRepository workRepo;

    @Autowired
    public MainController(UserRepository workRepo) {
        this.workRepo = workRepo;
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("workers", workRepo.findAll());
        model.addAttribute("title", "Home");
        return "main";
    }
}
