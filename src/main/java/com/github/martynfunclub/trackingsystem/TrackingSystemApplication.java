package com.github.martynfunclub.trackingsystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.martynfunclub.trackingsystem.models.Role;
import com.github.martynfunclub.trackingsystem.repositories.RoleRepository;

@SpringBootApplication
public class TrackingSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TrackingSystemApplication.class, args);
    }

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        roleRepository.saveAll(List.of(new Role("ADMIN"), new Role("USER")));
    }
}
