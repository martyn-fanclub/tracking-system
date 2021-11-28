package com.github.martynfunclub.trackingsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.martynfunclub.trackingsystem.models.Shift;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
    @Query(value = "select * from shifts s " +
            "where s.place=:id and s.end_time is null", nativeQuery = true)
    List<Shift> findByPlaceIdAndEndTimeIsNull(@Param("id") Long id);
}
