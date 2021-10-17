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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "changes")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    public Change(Timestamp startingTime, Timestamp endingTime, Worker worker, Set<Action> actions) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.worker = worker;
        this.actions = actions;
    }
}
