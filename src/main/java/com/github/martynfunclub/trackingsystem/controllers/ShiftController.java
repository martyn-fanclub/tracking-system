package com.github.martynfunclub.trackingsystem.controllers;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.martynfunclub.trackingsystem.models.Shift;
import com.github.martynfunclub.trackingsystem.models.User;
import com.github.martynfunclub.trackingsystem.models.WorkersPlace;
import com.github.martynfunclub.trackingsystem.repositories.ShiftRepository;
import com.github.martynfunclub.trackingsystem.repositories.UserRepository;
import com.github.martynfunclub.trackingsystem.services.PlaceService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/shift")
@AllArgsConstructor
public class ShiftController {
    ShiftRepository shiftRepository;
    UserRepository userRepository;
    PlaceService placeService;

    @PostMapping("/on")
    public String shiftOn(@RequestParam("id") Long placeId) {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }
        Optional<WorkersPlace> place = placeService.getPlaceById(placeId);
        if (place.isPresent()) {
            Shift shift = new Shift(LocalDateTime.now(), (User) authentication.getPrincipal(), Set.of(), place.get());
            shiftRepository.save(shift);
        }
        return "redirect:/";
    }

    @PostMapping("/off")
    public String shiftOff(@RequestParam("id") Long placeId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }

        Shift shift = shiftRepository.getShiftByPlaceIdAndEndTimeIsNullAndUser(placeId, (User) authentication.getPrincipal());
        if (shift != null) {
            shift.setEndTime(LocalDateTime.now());
            shiftRepository.save(shift);
        }
        return "redirect:/";
    }
}
