package com.example.GetRide.dto.request;

import com.example.GetRide.Enum.CabType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CabRequest {
    private String cabNumber;

    private CabType cabType;

    private double farePerKm;
}
