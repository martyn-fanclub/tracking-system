package com.github.martynfunclub.trackingsystem.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class CredentialsDto {
    @NotNull
    @NotBlank
    private String login;
    private String password;
}
