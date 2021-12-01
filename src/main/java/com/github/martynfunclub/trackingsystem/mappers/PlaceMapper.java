package com.github.martynfunclub.trackingsystem.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;

import com.github.martynfunclub.trackingsystem.models.Shift;
import com.github.martynfunclub.trackingsystem.models.User;
import com.github.martynfunclub.trackingsystem.models.WorkersPlace;
import com.github.martynfunclub.trackingsystem.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlaceMapper implements RowMapper<WorkersPlace> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final UserRepository userRepository;

    @Override
    public WorkersPlace mapRow(ResultSet rs, int rowNum) throws SQLException {
        WorkersPlace place = new WorkersPlace(rs.getLong("id"), rs.getString("place_name"), null);
        Shift shift = null;
        LocalDateTime localStartTime = null;
        LocalDateTime localEndTime = null;
        long shiftId = rs.getLong("s_id");
        if (shiftId != 0) {
            String startTime = rs.getString("start_time");
            String endTime = rs.getString("end_time");
            if (startTime != null) {
                localStartTime = LocalDateTime.parse(startTime.split("\\.")[0], FORMATTER);
            }
            if (endTime != null) {
                localEndTime = LocalDateTime.parse(endTime.split("\\.")[0], FORMATTER);
            }
            User worker = userRepository.findById(rs.getLong("worker_id")).orElse(null);
            shift = new Shift(shiftId, localStartTime, localEndTime, worker, Set.of(), place);
        }
        place.setCurrentShift(shift);
        place.setShifts(Collections.singleton(shift));
        return place;
    }
}
