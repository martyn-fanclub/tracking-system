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
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "productions")
@Entity
@Getter
@Setter
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "place")
    private WorkersPlace place;

    @ManyToOne(
            optional = false,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "change_id", nullable = false)
    private Change change;

    @Column(name = "start_time", nullable = false)
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @ManyToOne
    @JoinColumn(name = "detail_id")
    private Detail detail;

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", place=" + place.getName() +
                ", change=" + change.getStartTime() +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", detail=" + detail.getDetailType().getName() +
                '}';
    }
}