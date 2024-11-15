package com.example.GetRide.Transformer;

import com.example.GetRide.dto.request.CabRequest;
import com.example.GetRide.dto.response.CabResponse;
import com.example.GetRide.model.Cab;

public class CabTransformer {

    public static Cab cabRequestToCab(CabRequest cabRequest){
        Cab cab = Cab.builder()
                .cabNumber(cabRequest.getCabNumber())
                .cabType(cabRequest.getCabType())
                .farePerKm(cabRequest.getFarePerKm())
                .booked(false)
                .build();
        return cab;
    }

    public static CabResponse cabToCabResponse(Cab cab) {
        return CabResponse.builder()
                .cabNumber(cab.getCabNumber())
                .cabType(cab.getCabType())
                .farePerKm(cab.getFarePerKm())
                .booked(false).
                build();
    }
}
