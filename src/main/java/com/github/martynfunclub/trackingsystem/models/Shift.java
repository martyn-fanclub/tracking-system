package com.github.martynfunclub.trackingsystem.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "shifts")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "worker_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "shift", cascade = CascadeType.ALL)
    private Set<Production> productions;

    @OneToMany(mappedBy = "shift", cascade = CascadeType.ALL)
    private Set<Action> actions;

    @ManyToOne(optional = false)
    @JoinColumn(name = "place")
    private WorkersPlace place;

    public Shift(LocalDateTime startTime, User user, Set<Production> productions, WorkersPlace place) {
        this.startTime = startTime;
        this.user = user;
        this.productions = productions;
        this.place = place;
    }

    public Shift(Long id, LocalDateTime startTime, LocalDateTime endTime, User user, Set<Production> productions, WorkersPlace place) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.user = user;
        this.productions = productions;
        this.place = place;
    }
}
