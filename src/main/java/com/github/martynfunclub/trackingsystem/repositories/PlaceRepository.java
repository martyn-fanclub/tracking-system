package com.github.martynfunclub.trackingsystem.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.martynfunclub.trackingsystem.models.WorkersPlace;

public interface PlaceRepository extends JpaRepository<WorkersPlace, Long> {
    WorkersPlace getPlaceByName(String name);
    @Query(value = "select * from workers_place " +
            "left join shifts c on workers_place.id = c.place and c.end_time is null " +
            "left join productions p on c.id = p.shift_id and p.end_time is null " +
            "where c.end_time is null and place_name in ?1 limit 2", nativeQuery = true)
    List<WorkersPlace> getFirst2WorkersPlacesByNameIn(Collection<String> names);
}
