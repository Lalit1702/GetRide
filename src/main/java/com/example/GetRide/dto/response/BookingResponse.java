package com.example.GetRide.dto.response;

import com.example.GetRide.Enum.BookingStatus;
import com.example.GetRide.model.Customer;
import com.example.GetRide.model.Driver;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BookingResponse {

    String bookingId;

    String pickup;

    String destination;


    BookingStatus bookingStatus;

    double totalDistance;

    double totalFare;


    Date bookedAt;


    CustomerResponse customerResponse;


    DriverResponse driverResponse;
}
