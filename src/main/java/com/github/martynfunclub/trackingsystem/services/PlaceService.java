package com.github.martynfunclub.trackingsystem.services;

import java.util.List;

import javax.servlet.http.Cookie;

import com.github.martynfunclub.trackingsystem.models.WorkersPlace;

public interface PlaceService {
    List<WorkersPlace> getCurrentPlaces(Cookie[] cookies);
}
