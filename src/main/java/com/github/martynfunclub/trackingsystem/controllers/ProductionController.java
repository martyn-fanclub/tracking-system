package com.github.martynfunclub.trackingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.martynfunclub.trackingsystem.dto.IdDTO;
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
    public String createProduction(@ModelAttribute("IdDTO") IdDTO idDTO) {
        if (idDTO.getId() != null) {
            productionOnService.save(idDTO.getId());
        }
        return "redirect:/";
    }
}
