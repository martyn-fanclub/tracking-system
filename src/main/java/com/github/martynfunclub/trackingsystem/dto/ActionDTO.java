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

    private String comment;

    @NotBlank
    private Long actionTypeID;

    @NotBlank
    private Long shiftID;

/*    public ActionDTO(String comment, Long actionTypeID, Long shiftID) {
        this.comment = comment;
        this.actionTypeID = actionTypeID;
        this.shiftID = shiftID;
    }*/
}
