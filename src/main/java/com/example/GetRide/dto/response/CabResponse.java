package com.example.GetRide.dto.response;

import com.example.GetRide.Enum.CabType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CabResponse {

    String cabNumber;

    CabType cabType;

    double farePerKm;

    boolean booked;
}
