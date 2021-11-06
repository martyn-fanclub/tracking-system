package com.github.martynfunclub.trackingsystem.controllers;

import com.github.martynfunclub.trackingsystem.models.Detail;
import com.github.martynfunclub.trackingsystem.services.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/details")
public class DetailController {
    DetailService detailService;

    @Autowired
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping
    public String getDetails(Model model) {
        model.addAttribute("title", "All details");
        model.addAttribute("details", detailService.findAll());
        return "details/details";
    }

    @GetMapping("/{id}")
    public String getDetail(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("title", "detail with id " + id);
        try {
            Detail detail = detailService.findById(id).get();
            model.addAttribute("detail", detailService.findById(id).get());
            //[REDACT] add new page and more information
            return "details/detailInfo";
        } catch (NoSuchElementException ignored) {
            return "redirect:/details";
        }
    }

    @PostMapping
    public String createDetail(@RequestParam(name = "id") String id, Model model) {
        if ((id != null) && (!id.isEmpty())) {
            detailService.save(Integer.parseInt(id));
        }
        return "redirect:/details";
    }
}
