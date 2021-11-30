package com.github.martynfunclub.trackingsystem.repositories;

import java.util.List;

import com.github.martynfunclub.trackingsystem.models.WorkersPlace;

public interface CustomPlaceRepository {
    List<WorkersPlace> getWorkersPlacesByIdIn(List<Long> ids);
}
