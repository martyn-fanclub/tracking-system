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
public class ActionDTO {
    @NotBlank
    private Long actionTypeID;

    @NotBlank
    private Long productionID;
}
