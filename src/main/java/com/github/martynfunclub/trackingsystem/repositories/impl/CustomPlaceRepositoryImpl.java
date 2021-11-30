package com.github.martynfunclub.trackingsystem.repositories.impl;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.github.martynfunclub.trackingsystem.mappers.PlaceMapper;
import com.github.martynfunclub.trackingsystem.models.WorkersPlace;
import com.github.martynfunclub.trackingsystem.repositories.CustomPlaceRepository;
import com.github.martynfunclub.trackingsystem.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class CustomPlaceRepositoryImpl implements CustomPlaceRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final UserRepository userRepository;

    @Override
    public List<WorkersPlace> getWorkersPlacesByIdIn(List<Long> ids) {
        String sql = """
                SELECT wp.id, place_name, s.id as s_id, start_time, end_time, worker_id
                FROM workers_place wp
                LEFT JOIN shifts s on wp.id = s.place
                AND s.end_time IS NULL
                WHERE wp.id IN (:ids)
                """;
        SqlParameterSource params = new MapSqlParameterSource("ids", ids);
        return jdbcTemplate.query(sql, params, new PlaceMapper(userRepository));
    }
}
