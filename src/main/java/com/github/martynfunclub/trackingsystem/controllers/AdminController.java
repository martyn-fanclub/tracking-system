package com.github.martynfunclub.trackingsystem.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.martynfunclub.trackingsystem.repositories.PlaceRepository;
import com.github.martynfunclub.trackingsystem.repositories.ShiftRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    ShiftRepository shiftRepository;
    PlaceRepository placeRepository;

    @Autowired
    public AdminController(ShiftRepository shiftRepository, PlaceRepository placeRepository) {
        this.shiftRepository = shiftRepository;
        this.placeRepository = placeRepository;
    }

    @GetMapping("/assign")
    public String assign(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "admin/assign";
    }

    @GetMapping("/changes")
    public String getChanges(Model model) {
        model.addAttribute("title", "All changes");
        model.addAttribute("changes", shiftRepository.findAll());
        return "admin/changes";
    }

    @PostMapping("/changes/{id}")
    public String getChanges(@PathVariable Long id, Model model) {
        model.addAttribute("title", "Change id");
        model.addAttribute("change", shiftRepository.findById(id));
        return "admin/change";
    }
}
