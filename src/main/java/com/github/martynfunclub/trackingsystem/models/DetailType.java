package com.github.martynfunclub.trackingsystem.models;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "detail_types")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "max_time", nullable = false)
    private LocalTime maxTime;

    public DetailType(String name, LocalTime maxTime) {
        this.name = name;
        this.maxTime = maxTime;
    }
}
