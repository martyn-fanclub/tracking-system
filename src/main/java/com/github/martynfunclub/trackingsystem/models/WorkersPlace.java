package com.github.martynfunclub.trackingsystem.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "workers_place")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkersPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "place_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "place", fetch = FetchType.EAGER)
    private Set<Production> productions;

    @Transient
    private Production currentProduction;

    @Override
    public String toString() {
        return "WorkersPlace{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actions=" + productions +
                '}';
    }
}