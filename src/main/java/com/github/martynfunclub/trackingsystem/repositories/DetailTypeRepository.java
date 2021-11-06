package com.github.martynfunclub.trackingsystem.repositories;

import com.github.martynfunclub.trackingsystem.models.DetailType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailTypeRepository extends JpaRepository<DetailType, Long> {
    DetailType findByName(String name);
}
