package com.github.martynfunclub.trackingsystem.repositories;

import com.github.martynfunclub.trackingsystem.models.DetailType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetailTypeRepository extends JpaRepository<DetailType, Long> {
    @Override
    Optional<DetailType> findById(Long aLong);

    DetailType findByName(String name);
}
