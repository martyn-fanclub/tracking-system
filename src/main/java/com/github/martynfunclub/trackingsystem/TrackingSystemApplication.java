package com.github.martynfunclub.trackingsystem;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.github.martynfunclub.trackingsystem.models.PhoneNumber;
import com.github.martynfunclub.trackingsystem.models.Role;
import com.github.martynfunclub.trackingsystem.models.User;
import com.github.martynfunclub.trackingsystem.repositories.RoleRepository;
import com.github.martynfunclub.trackingsystem.repositories.UserRepository;

@SpringBootApplication
public class TrackingSystemApplication implements CommandLineRunner {
    RoleRepository roleRepository;
    UserRepository userRepository;

    @Autowired
    public TrackingSystemApplication(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TrackingSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Role admin = new Role("ROLE_ADMIN");
//        roleRepository.saveAll(Set.of(new Role("ROLE_WORKER"), admin));
//        userRepository.save(new User("Вася", "Пупкин", "Владимирович", "admin",
//                new BCryptPasswordEncoder().encode("admin"), Set.of(new PhoneNumber("88005553535")),
//                "admin", 0L, "skills", Set.of(admin)));
    }
}
