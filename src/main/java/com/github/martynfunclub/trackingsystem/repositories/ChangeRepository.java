package com.github.martynfunclub.trackingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.github.martynfunclub.trackingsystem.models.Change;
import com.github.martynfunclub.trackingsystem.models.WorkersPlace;

@Repository
public interface ChangeRepository extends JpaRepository<Change, Long> {
    Change getChangeByPlaceAndEndTimeIsNull(WorkersPlace place);

    @Query("select c from Change c join WorkersPlace wp on c.place = :place and c.endTime is null join Production prod on prod.change = c where prod.endTime is null")
    Change getChangeByPlaceAndEndTimeIsNullWithProductionEndTimeIsNull(@Param("place") WorkersPlace place);
}
