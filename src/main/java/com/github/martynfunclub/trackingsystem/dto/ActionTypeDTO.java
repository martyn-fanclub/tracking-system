package com.github.martynfunclub.trackingsystem.dto;

import java.sql.Time;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActionTypeDTO {
    @NotBlank
    private String name;

    private int maxTime;
}
