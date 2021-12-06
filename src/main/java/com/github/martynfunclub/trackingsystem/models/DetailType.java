package com.github.martynfunclub.trackingsystem.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany(mappedBy = "detailType")
    private Set<Detail> details;

    @OneToMany(mappedBy = "from")
    private Set<OrderType> orderTypesFrom;

    @OneToMany(mappedBy = "to")
    private Set<OrderType> orderTypesTo;

    public DetailType(String name) {
        this.name = name;
    }
}
