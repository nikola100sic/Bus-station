package com.example.BusStation.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime reservationTime;

    @Column(nullable = false)
    private int seatNumber;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "line_id", nullable = false)
    private Line busLine;

}
