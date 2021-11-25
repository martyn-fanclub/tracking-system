package com.github.martynfunclub.trackingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
//                new BCryptPasswordEncoder().encode("admin"), Set.of(new Number("88005553535")),
//                "admin", 0L, "skills", Set.of(admin)));
    }
}
