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

@Entity(name = "actions")
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

    public Action() {
    }

    public Action(Timestamp startingTime, Timestamp endingTime, Integer timeLimit, ActionType actionType, Change change) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.timeLimit = timeLimit;
        this.actionType = actionType;
        this.change = change;
    }

    public Action(Long id, Timestamp startingTime, Timestamp endingTime, Integer timeLimit, ActionType actionType, Change change) {
        this.id = id;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.timeLimit = timeLimit;
        this.actionType = actionType;
        this.change = change;
    }

    public Change getChange() {
        return change;
    }

    public void setChange(Change change) {
        this.change = change;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Timestamp startingTime) {
        this.startingTime = startingTime;
    }

    public Timestamp getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Timestamp endingTime) {
        this.endingTime = endingTime;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }
}
