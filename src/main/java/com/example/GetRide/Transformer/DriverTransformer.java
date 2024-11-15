package com.example.GetRide.Transformer;

import com.example.GetRide.dto.request.DriverRequest;
import com.example.GetRide.dto.response.DriverResponse;
import com.example.GetRide.model.Driver;

public class DriverTransformer {
    public static Driver driverRequestToDriver(DriverRequest driverRequest){
 //       Driver driver  = new Driver();
//        driver.setName(driverRequest.getName());
//        driver.setAge(driverRequest.getAge());
//        driver.setDrivingLicense(driver.getDrivingLicense());
//        driver.setMobileNo(driverRequest.getMobileNo());

        Driver driver = Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .drivingLicense(driverRequest.getDrivingLicense())
                .mobileNo(driverRequest.getMobileNo())
                .build();

        return driver;
    }

    public static DriverResponse driverToDriverResponse(Driver driver) {
//        DriverResponse driverResponse = new DriverResponse();
//        driverResponse.setName(driver.getName());
//        driverResponse.setMobNo(driver.getMobileNo());
//        driverResponse.setCabResponse(driver.getCab());

        return DriverResponse.builder()
                .name(driver.getName())
                .mobNo(driver.getMobileNo())
                .cabResponse(CabTransformer.cabToCabResponse(driver.getCab()))
                .build();
    }
}
