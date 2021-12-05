package com.github.martynfunclub.trackingsystem.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.martynfunclub.trackingsystem.dto.IdDTO;
import com.github.martynfunclub.trackingsystem.models.Detail;
import com.github.martynfunclub.trackingsystem.services.DetailService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/details")
@AllArgsConstructor
public class DetailController {
    DetailService detailService;

    @GetMapping
    public String getDetails(Model model) {
        model.addAttribute("title", "All details");
        model.addAttribute("details", detailService.findAll());
        model.addAttribute("IdDTO", new IdDTO());
        return "details/details";
    }

    @GetMapping("/{id}")
    public String getDetail(@PathVariable(name = "id") Long id, Model model) {
        Optional<Detail> detail = detailService.findById(id);
        if (detail.isPresent()) {
            model.addAttribute("detail", detail.get());
            model.addAttribute("title", "detail with id " + id);
            //[REDACT] add new page and more information
            return "details/detailInfo";
        }
        return "redirect:/details";
    }

    @PostMapping
    public String createDetail(@ModelAttribute("IdDTO") IdDTO idDTO) {
        if (idDTO.getId() != null) {
            detailService.save(idDTO.getId());
        }
        return "redirect:/details";
    }
}
