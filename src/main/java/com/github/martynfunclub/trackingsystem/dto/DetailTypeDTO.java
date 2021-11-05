package com.github.martynfunclub.trackingsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetailTypeDTO {
    @NotBlank
    private String name;

    private String maxTime;
}
