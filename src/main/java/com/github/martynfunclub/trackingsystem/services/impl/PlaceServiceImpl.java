package com.github.martynfunclub.trackingsystem.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.martynfunclub.trackingsystem.models.WorkersPlace;
import com.github.martynfunclub.trackingsystem.repositories.PlaceRepository;
import com.github.martynfunclub.trackingsystem.services.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService {
    private static final int MAX_PLACES = 2;
    private static final String COOKIE_NAME = "test";

    PlaceRepository placeRepository;

    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public List<WorkersPlace> getCurrentPlaces(Cookie[] cookies) {
        if (cookies == null) {
            return Collections.emptyList();
        }
        Cookie placeCookie = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("test")) {
                placeCookie = cookie;
                break;
            }
        }
        String cookieValue = placeCookie == null ? "" : placeCookie.getValue();
        String[] cookieValues = cookieValue.split(":+");
        List<WorkersPlace> places = new ArrayList<>(MAX_PLACES);
        for (String cookie : cookieValues) {
            WorkersPlace place = placeRepository.getPlaceByName(cookie);
            if (place != null) {
                places.add(place);
            }
        }
        return places;
    }

    @Override
    public List<String> getPlacesNames(Cookie[] cookies) {
        if ((cookies == null) || (cookies.length == 0)) {
            return Collections.emptyList();
        }
        Optional<Cookie> cookie = Arrays.stream(cookies)
                .filter(c -> c.getName().equals(COOKIE_NAME))
                .findFirst();
        if (cookie.isEmpty()) {
            return Collections.emptyList();
        }
        String[] placesNames = cookie.get().getValue().split(":+");
        return List.of(placesNames);
    }

    @Override
    public Optional<WorkersPlace> getPlaceById(Long id) {
        return placeRepository.findById(id);
    }
}
