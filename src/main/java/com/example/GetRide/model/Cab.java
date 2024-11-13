package com.example.GetRide.model;

import com.example.GetRide.Enum.CabType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cab")
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cabNumber;

    @Enumerated(EnumType.STRING)
    private CabType cabType;

    private double farePerKm;

    private boolean booked;

    @OneToOne
    @JoinColumn
    private Driver driver;
}
