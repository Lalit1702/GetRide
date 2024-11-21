package com.example.GetRide.model;

import com.example.GetRide.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "booking")
@FieldDefaults(level = AccessLevel.PRIVATE) //make all variables private has less priority
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String bookingId;

    String pickup;

    String destination;

    @Enumerated(EnumType.STRING)
    BookingStatus bookingStatus;

    double totalDistance;

    double totalFare;

    @CreationTimestamp
    Date bookedAt; // util - date and time sql - time

    @ManyToOne
    @JoinColumn
    Customer customer;

    @ManyToOne
    @JoinColumn
    Driver driver;

}
