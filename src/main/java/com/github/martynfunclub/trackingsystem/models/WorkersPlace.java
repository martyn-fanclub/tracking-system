package com.github.martynfunclub.trackingsystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "workers_place")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WorkersPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "place_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "place", fetch = FetchType.EAGER)
    private Set<Shift> shifts;

    @ManyToMany
    private List<DetailType> detailType;

    @Transient
    private Shift currentShift;

    public WorkersPlace(Long id, String name, Shift currentShift) {
        this.id = id;
        this.name = name;
        this.currentShift = currentShift;
    }
}
