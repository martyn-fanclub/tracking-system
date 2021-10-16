package com.github.martynfunclub.trackingsystem.models;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "changes")
public class Change {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Timestamp startingTime;

    @Column(nullable = false)
    private Timestamp endingTime;

    @ManyToOne(optional = false)
    private Worker worker;

    @OneToMany(targetEntity = Action.class, cascade = CascadeType.ALL, mappedBy = "change")
    private Set<Action> actions;

    public Change(Timestamp startingTime, Timestamp endingTime, Worker worker) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.worker = worker;
    }

    public Change() {
    }

    public Change(Long id, Timestamp startingTime, Timestamp endingTime, Worker worker) {
        this.id = id;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.worker = worker;
    }

    public Change(Timestamp startingTime, Timestamp endingTime, Worker worker, Set<Action> actions) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.worker = worker;
        this.actions = actions;
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

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }
}
