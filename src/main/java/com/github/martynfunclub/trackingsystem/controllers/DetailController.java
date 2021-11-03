package com.github.martynfunclub.trackingsystem.controllers;

import com.github.martynfunclub.trackingsystem.repositories.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/details")
public class DetailController {

    @Autowired
    DetailRepository detailsRepository;

    @GetMapping("")
    public String getDetails(Model model) {
        model.addAttribute("title", "All details");
        model.addAttribute("details", detailsRepository.findAll());
        return "details/details";
    }

    @GetMapping("/detail")
    public String getDetail(@PathVariable Long id, Model model) {
        model.addAttribute("title", "details with id " + id);
        model.addAttribute("details", detailsRepository.findById(id));
        //[REDACT] add new page and more information
        return "details/details";
    }

    @PostMapping
    public String createDetail(@PathVariable long id, Model model) {

        model.addAttribute("title", "All details");
        model.addAttribute("details", detailsRepository.findAll());
        //[REDACT] add new page and more information
        return "details/details";
    }


}
