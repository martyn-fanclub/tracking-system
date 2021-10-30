package com.github.martynfunclub.trackingsystem.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.martynfunclub.trackingsystem.models.WorkersPlace;
import com.github.martynfunclub.trackingsystem.repositories.PlaceRepository;
import com.github.martynfunclub.trackingsystem.services.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService {
    private static final int MAX_PLACES = 2;

    PlaceRepository placeRepository;

    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public List<WorkersPlace> getCurrentPlaces(Cookie[] cookies) {
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
}
