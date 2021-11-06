package com.github.martynfunclub.trackingsystem.controllers;

import com.github.martynfunclub.trackingsystem.services.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/details")
public class DetailController {

    @Autowired
    DetailService detailService;

    @GetMapping("")
    public String getDetails(Model model) {
        model.addAttribute("title", "All details");
        model.addAttribute("details", detailService.findAll());
        return "details/details";
    }

    @GetMapping("/{id}")
    public String getDetail(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("title", "detail with id " + id);
        model.addAttribute("detail", detailService.findById(id).get());
        //[REDACT] add new page and more information
        return "details/detailInfo";
    }

    @PostMapping
    public String createDetail(@RequestParam(name = "id") Long id, Model model) {
        detailService.save(id);
        return "redirect:/details";
    }


}
