package com.example.GetRide.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DriverResponse {

    String name;

    long mobNo;

    CabResponse cabResponse;
}
