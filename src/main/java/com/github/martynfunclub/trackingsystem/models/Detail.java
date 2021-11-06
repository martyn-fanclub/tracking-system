package com.github.martynfunclub.trackingsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    public Detail(DetailType detailType) {
        this.detailType = detailType;
    }
}