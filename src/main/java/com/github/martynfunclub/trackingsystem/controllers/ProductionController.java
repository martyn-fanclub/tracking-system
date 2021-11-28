package com.github.martynfunclub.trackingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.martynfunclub.trackingsystem.services.ProductionOnService;

@Controller
@RequestMapping("/production/on")
public class ProductionController {
    ProductionOnService productionOnService;

    @Autowired
    public ProductionController(ProductionOnService productionOnService) {
        this.productionOnService = productionOnService;
    }

    @PostMapping
    public String createProduction(@RequestParam(value = "placeId") Long placeId) {
        productionOnService.save(placeId);
        return "redirect:/";
    }
}
