package com.github.martynfunclub.trackingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.martynfunclub.trackingsystem.services.ProductionService;

@Controller
@RequestMapping("/production")
public class ProductionController {
    ProductionService productionService;

    @Autowired
    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @PostMapping("/on")
    public String createProduction(@RequestParam Long placeId) {
        productionService.save(placeId);
        return "redirect:/";
    }
}
