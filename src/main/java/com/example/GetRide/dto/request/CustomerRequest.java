package com.example.GetRide.dto.request;

import com.example.GetRide.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {

    private String name;

    private int age;

    private String emailId;

    private Gender gender;
    //not get stored in database so no need of any annotations
}
