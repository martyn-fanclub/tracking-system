package com.github.martynfunclub.trackingsystem.services;

import java.util.Set;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.github.martynfunclub.trackingsystem.dto.UserDTO;
import com.github.martynfunclub.trackingsystem.models.User;
import com.github.martynfunclub.trackingsystem.repositories.RoleRepository;
import com.github.martynfunclub.trackingsystem.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private EntityManager entityManager;

    UserRepository userRepository;
    RoleRepository roleRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(EntityManager entityManager, UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.entityManager = entityManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public boolean createAdmin(UserDTO userDTO) {
        User userFromDB = userRepository.findByUsername(userDTO.getUsername());

        if (userFromDB != null) {
            return false;
        }
        User newUser = new User(userDTO.getName(), userDTO.getSurname(), userDTO.getPatronymic(), userDTO.getUsername(), userDTO.getPersonnelNumber(), userDTO.getSalary(), userDTO.getSkills());
        newUser.setNumbers(userDTO.getNumbers());
        newUser.setRoles(Set.of(roleRepository.getRoleByName("ROLE_ADMIN")));
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);
        return true;
    }

    public boolean saveUser(UserDTO userDTO) {
        User userFromDB = userRepository.findByUsername(userDTO.getUsername());

        if (userFromDB != null) {
            return false;
        }
        User newUser = new User(userDTO.getName(), userDTO.getSurname(), userDTO.getPatronymic(), userDTO.getUsername(), userDTO.getPersonnelNumber(), userDTO.getSalary(), userDTO.getSkills());
        newUser.setNumbers(userDTO.getNumbers());
        newUser.setRoles(Set.of(roleRepository.getRoleByName("ROLE_WORKER")));
        newUser.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userRepository.save(newUser);
        return true;
    }
}
