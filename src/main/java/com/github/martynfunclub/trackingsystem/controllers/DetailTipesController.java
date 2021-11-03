package com.github.martynfunclub.trackingsystem.controllers;

import com.github.martynfunclub.trackingsystem.models.DetailType;
import com.github.martynfunclub.trackingsystem.repositories.DetailTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;

@Controller
@RequestMapping("/detailsTypes")
public class DetailTipesController {

    @Autowired
    DetailTypeRepository detailsTypeRepository;

    @GetMapping("")
    public String main(Model model) {
        model.addAttribute("title", "All detail types");
        model.addAttribute("detailTypes", detailsTypeRepository.findAll());
        return "details/typesDetails";
    }

    @GetMapping("/createNewTypeDetail")
    public String createNewTypeDetail(@RequestParam String name, @RequestParam String maxTime, Model model) {
        DetailType detailType = new DetailType(name, maxTime);
        detailsTypeRepository.save(detailType);
        model.addAttribute("title", "All detail types");
        model.addAttribute("detailTypes", detailsTypeRepository.findAll());

        return "details/typesDetails";
    }
}
