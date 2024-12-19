package com.example.BusStation.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String plateNumber;

    @Column(nullable = false)
    private int capacity;

    @ManyToOne
    private Carrier carrier;

    @ManyToMany(mappedBy = "buses")
    private Set<Line> lines;


}
