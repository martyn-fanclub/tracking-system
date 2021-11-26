package com.github.martynfunclub.trackingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.martynfunclub.trackingsystem.services.ProductionService;

@Controller
@RequestMapping("/production/off")
public class ProductionOffController {
    ProductionService productionService;

    @Autowired
    public ProductionOffController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @PostMapping
    public String finishProduction(Long id)
    {
        productionService.save(id);
        return "redirect:/";
    }

}
