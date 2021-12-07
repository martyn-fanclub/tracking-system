package com.github.martynfunclub.trackingsystem.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "productions")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(
            optional = false,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "shift_id", nullable = false)
    private Shift shift;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Order order;

    public Production(Shift shift, LocalDateTime startTime, LocalDateTime endTime, Order order) {
        this.shift = shift;
        this.startTime = startTime;
        this.endTime = endTime;
        this.order = order;
    }
}
