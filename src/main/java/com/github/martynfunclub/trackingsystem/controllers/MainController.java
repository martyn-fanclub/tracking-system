package com.github.martynfunclub.trackingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.martynfunclub.trackingsystem.models.Worker;
import com.github.martynfunclub.trackingsystem.dao.WorkerRepository;

@Controller
public class MainController {

    WorkerRepository workRepo;

    @Autowired
    public MainController(WorkerRepository workRepo) {
        this.workRepo = workRepo;
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("workers", workRepo.findAll());
        model.addAttribute("title", "Home");
        return "main";
    }

    @GetMapping("/create")
    public String create(@RequestParam(value = "name") String login, Model model) {
        Worker worker = new Worker("Petya", "Pupkin", login, "123", "321");
        workRepo.save(worker);
        model.addAttribute(worker);
        model.addAttribute("title", "Create");
        return "success";
    }
}
