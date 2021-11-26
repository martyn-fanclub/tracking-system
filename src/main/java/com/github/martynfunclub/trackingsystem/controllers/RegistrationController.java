package com.github.martynfunclub.trackingsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.martynfunclub.trackingsystem.dto.UserDTO;
import com.github.martynfunclub.trackingsystem.services.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    UserService userService;

    @GetMapping
    public String registration(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((auth == null) || (auth instanceof AnonymousAuthenticationToken)) {
            model.addAttribute("user", new UserDTO());
            return "/registration";
        }
        return "redirect:/";
    }

    @PostMapping
    public String registration(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userDTO.getPassword().equals(userDTO.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Passwords are not equal");
            return "registration";
        }
        if (!userService.saveUser(userDTO)) {
            model.addAttribute("usernameError", "User with this username already exists");
            return "registration";
        }

        return "redirect:/";
    }
}
