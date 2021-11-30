package com.github.martynfunclub.trackingsystem.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.martynfunclub.trackingsystem.models.WorkersPlace;
import com.github.martynfunclub.trackingsystem.repositories.ShiftRepository;
import com.github.martynfunclub.trackingsystem.services.PlaceService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
    PlaceService placeService;
    ShiftRepository shiftRepository;

    @GetMapping("/")
    public String main(HttpServletRequest request, Model model) {
        model.addAttribute("places", placeService.getCurrentPlaces(request.getCookies()));
        model.addAttribute("title", "Станки");
        return "main";
    }
}
