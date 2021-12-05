package com.github.martynfunclub.trackingsystem.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "details")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "detail_type_id", nullable = false)
    private DetailType detailType;

    @OneToMany(mappedBy = "detail")
    private Set<Order> orders;

    @OneToOne(mappedBy = "detail")
    private Cell cell;

    private Boolean isTaken;

    public Detail(DetailType detailType) {
        this.detailType = detailType;
    }
}
