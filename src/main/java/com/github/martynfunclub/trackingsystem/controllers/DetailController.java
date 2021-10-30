package com.github.martynfunclub.trackingsystem.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.martynfunclub.trackingsystem.repositories.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.martynfunclub.trackingsystem.models.Detail;
import com.github.martynfunclub.trackingsystem.models.DetailType;

@Controller
@RequestMapping("/details")
public class DetailController {

    @Autowired
    DetailRepository detailsRepository;

    @GetMapping("")
    public String getDetails(Model model) {
        model.addAttribute("title", "All details");
        model.addAttribute("details", detailsRepository.findAll());
        return "details";
    }

    @GetMapping("/{id}")
    public String getDetail(@PathVariable Long id, Model model) {
        model.addAttribute("title", "All details");
        model.addAttribute("details", detailsRepository.findById(id));
        //[REDACT] add new page and more information
        return "details";
    }

}
