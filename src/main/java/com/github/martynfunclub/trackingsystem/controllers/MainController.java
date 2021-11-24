package com.github.martynfunclub.trackingsystem.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.github.martynfunclub.trackingsystem.models.WorkersPlace;
import com.github.martynfunclub.trackingsystem.repositories.ChangeRepository;
import com.github.martynfunclub.trackingsystem.repositories.PlaceRepository;
import com.github.martynfunclub.trackingsystem.services.PlaceService;

@Controller
public class MainController {

    PlaceService placeService;
    ChangeRepository changeRepository;
    PlaceRepository placeRepository;

    @Autowired
    public MainController(PlaceService placeService, ChangeRepository changeRepository, PlaceRepository placeRepository) {
        this.placeService = placeService;
        this.changeRepository = changeRepository;
        this.placeRepository = placeRepository;
    }

    @GetMapping("/")
    public String main(HttpServletRequest request, Model model) {
        List<WorkersPlace> places = placeRepository.getFirst2WorkersPlacesByNameIn(placeService.getPlacesNames(request.getCookies()));
        for (WorkersPlace place : places) {
            place.setCurrentChange(changeRepository.getChangeByPlaceAndEndTimeIsNullWithProductionEndTimeIsNull(place));
        }
        model.addAttribute("places", places);
        model.addAttribute("title", "Станки");
        return "main";
    }
}
