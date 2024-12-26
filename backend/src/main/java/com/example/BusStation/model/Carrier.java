package com.example.BusStation.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Carrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String eMail;
    
}
