package com.github.martynfunclub.trackingsystem.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Service;

import com.github.martynfunclub.trackingsystem.models.Status;
import com.github.martynfunclub.trackingsystem.models.WorkersPlace;
import com.github.martynfunclub.trackingsystem.repositories.OrderRepository;
import com.github.martynfunclub.trackingsystem.repositories.PlaceRepository;
import com.github.martynfunclub.trackingsystem.repositories.ShiftRepository;
import com.github.martynfunclub.trackingsystem.services.PlaceService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlaceServiceImpl implements PlaceService {
    private static final int MAX_PLACES = 2;
    private static final String COOKIE_NAME = "test";

    private final PlaceRepository placeRepository;
    private final ShiftRepository shiftRepository;
    private final OrderRepository orderRepository;

    @Override
    public List<WorkersPlace> getCurrentPlaces(Cookie[] cookies) {
        if (cookies == null) {
            return Collections.emptyList();
        }
        String[] cookieValues = getPlacesIds(cookies);
        if (cookieValues.length > MAX_PLACES) {
            return List.of();
        }
        List<Long> placeIds = new ArrayList<>(MAX_PLACES);
        try {
            for (String cookie : cookieValues) {
                placeIds.add(Long.parseLong(cookie));
            }
        } catch (NumberFormatException e) {
            return List.of();
        }
        List<WorkersPlace> places = placeRepository.findAll();
        for (WorkersPlace place : places) {
            place.setCurrentShift(shiftRepository.getShiftByPlaceIdAndEndTimeIsNull(place.getId()));
            place.setCurrentOrders(orderRepository.findByOrderTypeInAndStatusIsOrderByPriorityDesc(place.getOrderTypes(), Status.PENDING));
        }
        return places;
    }

    @Override
    public Optional<WorkersPlace> getPlaceById(Long id) {
        return placeRepository.findById(id);
    }

    private String[] getPlacesIds(Cookie[] cookies) {
        String cookieValue = "";
        Optional<Cookie> cookie = Arrays.stream(cookies).filter(c -> COOKIE_NAME.equals(c.getName())).findFirst();
        if (cookie.isPresent()) {
            cookieValue = cookie.get().getValue();
        }
        return cookieValue.split(":+");
    }
}
