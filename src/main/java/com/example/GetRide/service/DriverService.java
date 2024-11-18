package com.example.GetRide.service;

import com.example.GetRide.Transformer.CabTransformer;
import com.example.GetRide.Transformer.DriverTransformer;
import com.example.GetRide.dto.request.DriverRequest;
import com.example.GetRide.dto.response.DriverResponse;
import com.example.GetRide.model.Cab;
import com.example.GetRide.model.Driver;
import com.example.GetRide.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;
    public String addDriverAndCab(DriverRequest driverRequest) {
        //dto--entity
        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);
        Cab cab = CabTransformer.cabRequestToCab(driverRequest.getCabRequest());

        driver.setCab(cab);
        cab.setDriver(driver);

        //save both driver and cab
        driverRepository.save(driver); //cascading

        return "Driver Registered Successfully";

    }

    public DriverResponse getDriver(long mobileNo) {
        Driver savedDriver = driverRepository.findByMobileNo(mobileNo);
        return DriverTransformer.driverToDriverResponse(savedDriver);
    }


    public List<DriverResponse> getDriverAboveAge(int age) {
        List<Driver> drivers =  driverRepository.getDriverAboveAge(age);
        List<DriverResponse> driverResponses = new ArrayList<>();
        for(Driver driver:drivers){
            driverResponses.add(DriverTransformer.driverToDriverResponse(driver));
        }
        return driverResponses;
    }

    public String updateDriverLicense(String driverLicense, long mobileNO) {
        driverRepository.updateDriverLicense(driverLicense,mobileNO);
        return "Driving License Number of Driver has been Updated";
    }

    public String updateDriverMobNo(long newMobNo, long oldMobNo) {
        driverRepository.updateDriverMobNo(newMobNo,oldMobNo);
        return "Mobile Number of Driver Has Been Updated Successfully";
    }
}
