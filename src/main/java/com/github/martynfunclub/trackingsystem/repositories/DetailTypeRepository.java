package com.github.martynfunclub.trackingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.martynfunclub.trackingsystem.models.DetailType;

public interface DetailTypeRepository extends JpaRepository<DetailType, Long> {
    DetailType findByName(String name);
}
