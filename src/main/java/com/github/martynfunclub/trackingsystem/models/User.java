package com.github.martynfunclub.trackingsystem.models;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "surname", nullable = false, length = 45)
    private String surname;

    @Column(name = "patronymic", length = 45)
    private String patronymic;

    @Column(name = "login", nullable = false, length = 45)
    private String username;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Number> numbers;

    @Column(name = "personnel_number", nullable = false, length = 60, unique = true)
    private String personnelNumber;

    @Column(name = "salary", columnDefinition = "bigint default 0")
    private Long salary;

    @Column(name = "skills", columnDefinition = "TEXT")
    private String skills;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(String name, String surname, String username, String password, String personnelNumber, Long salary, Set<Role> roles) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.personnelNumber = personnelNumber;
        this.salary = salary;
        this.roles = roles;
    }

    public User(String name, String surname, String patronymic, String username, String personnelNumber, Long salary, String skills) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.username = username;
        this.personnelNumber = personnelNumber;
        this.salary = salary;
        this.skills = skills;
    }

    public User(String name, String surname, String patronymic, String username, String password, Set<Number> numbers, String personnelNumber, Long salary, String skills, Set<Role> roles) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.username = username;
        this.password = password;
        this.numbers = numbers;
        this.personnelNumber = personnelNumber;
        this.salary = salary;
        this.skills = skills;
        this.roles = roles;
    }

    public void setNumbers(Set<Number> numbers) {
        if (numbers != null) {
            for (Number number : numbers) {
                number.setUser(this);
            }
        }
        this.numbers = numbers;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}