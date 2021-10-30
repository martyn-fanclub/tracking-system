package com.github.martynfunclub.trackingsystem.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.github.martynfunclub.trackingsystem.models.Number;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotNull
    private String patronymic;

    @NotBlank
    private String personnelNumber;

    @NotNull
    private Set<Number> numbers;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordConfirm;

    @NotNull
    private Long salary;

    @NotNull
    private String skills;

    public UserDTO(String name, String surname, String personnelNumber,  String username, String password) {
        this.name = name;
        this.surname = surname;
        this.personnelNumber = personnelNumber;
        this.username = username;
        this.password = password;
    }
}
