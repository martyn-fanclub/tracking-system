package com.github.martynfunclub.trackingsystem.controllers;

import com.github.martynfunclub.trackingsystem.dto.DetailTypeDTO;
import com.github.martynfunclub.trackingsystem.services.DetailTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/detailsTypes")
public class DetailTypesController {
    DetailTypeService detailsTypeService;

    @Autowired
    public DetailTypesController(DetailTypeService detailsTypeService) {
        this.detailsTypeService = detailsTypeService;
    }

    @GetMapping
    public String getAllTypeDetail(Model model) {
        model.addAttribute("title", "All detail types");
        model.addAttribute("detailTypes", detailsTypeService.findAll());
        return "details/typesDetails";
    }

    @GetMapping("/createNew")
    public String createNewTypeDetailForm(Model model) {
        model.addAttribute("detailTypeForm", new DetailTypeDTO());
        model.addAttribute("title", "create new detail");

        return "details/createTypeDetailForm";
    }

    @PostMapping
    public String createNewTypeDetail(@ModelAttribute("detailTypeForm") @Valid DetailTypeDTO detailTypeDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            detailsTypeService.save(detailTypeDTO);
        }
        return "redirect:/detailsTypes";
    }

    @PostMapping("/deleteDetailType")
    public String deleteTypeDetail(@RequestParam(name = "id") String id) {
        if ((id != null) && !id.isEmpty()) {
            try {
                detailsTypeService.deleteById((long) Integer.parseInt(id));
            } catch (EmptyResultDataAccessException ignored) {
            }
        }
        return "redirect:/detailsTypes";
    }
}
