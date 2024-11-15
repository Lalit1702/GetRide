package com.example.GetRide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "driver")
@FieldDefaults(level = AccessLevel.PRIVATE) //make all variables private has less priority
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "driver_name")
    String name;

    int age;

    @Column(unique = true,nullable = false)
    String drivingLicense;

    @Column(unique = true,nullable = false)
    long mobileNo;

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)

    Cab cab;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Booking> booking = new ArrayList<>();
}
