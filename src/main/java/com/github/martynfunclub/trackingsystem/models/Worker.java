package com.github.martynfunclub.trackingsystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "workers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String salt;

    public Worker(String name, String surname, String login, String password, String salt) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.salt = salt;
    }
}
