package com.example.GetRide.controller;

import com.example.GetRide.dto.request.DriverRequest;
import com.example.GetRide.dto.response.DriverResponse;
import com.example.GetRide.model.Driver;
import com.example.GetRide.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/add-driver")
    public ResponseEntity addDriverAndCab(@RequestBody DriverRequest driverRequest){
        String response = driverService.addDriverAndCab(driverRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-driver-by-mobile")
    public DriverResponse getDriver(@RequestParam("mob-no") long mobileNo){
        return driverService.getDriver(mobileNo);
    }

    // get all the drivers above a particular age
    @GetMapping("/get-driver-by-age")
    public List<DriverResponse> getDriverAboveAge(@RequestParam("age") int age){
        return driverService.getDriverAboveAge(age);
    }

    // get the driver with maximum number of bookings

    //update  the driver license
    @PutMapping("/update-driver-license")
    public ResponseEntity updateDriverLicense(@RequestParam("license") String driverLicense, @RequestParam("mob-no") long mobileNO){
        String response = driverService.updateDriverLicense(driverLicense,mobileNO);
        return new ResponseEntity(response,HttpStatus.CREATED);
    }

    //update driver phone number
    @PutMapping("/update-driver-mobNo")
    public ResponseEntity updateDriverMobNo(@RequestParam("new-mob-no") long newMobNo, @RequestParam("old-mob-no") long oldMobNo){
        String response = driverService.updateDriverMobNo(newMobNo,oldMobNo);
        return new ResponseEntity(response,HttpStatus.CREATED);
    }

    // driver with the least number of bookings

    // get all the drivers with less than 10 bookings
}
