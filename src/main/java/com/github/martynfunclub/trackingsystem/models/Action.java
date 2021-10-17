package com.github.martynfunclub.trackingsystem.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "actions")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Timestamp startingTime;

    @Column(nullable = false)
    private Timestamp endingTime;

    private Integer timeLimit;

    @ManyToOne(optional = false)
    private ActionType actionType;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "change_id")
    @JsonIgnore
    private Change change;

    public Action(Timestamp startingTime, Timestamp endingTime, Integer timeLimit, ActionType actionType, Change change) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.timeLimit = timeLimit;
        this.actionType = actionType;
        this.change = change;
    }
}
