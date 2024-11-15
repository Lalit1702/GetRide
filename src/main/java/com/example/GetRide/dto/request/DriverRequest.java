package com.example.GetRide.dto.request;

import com.example.GetRide.model.Cab;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DriverRequest {

    String name;

    int age;

    String drivingLicense;

    long mobileNo;

    CabRequest cabRequest;
}
