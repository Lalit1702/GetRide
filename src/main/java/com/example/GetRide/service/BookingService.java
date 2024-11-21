package com.example.GetRide.service;

import com.example.GetRide.Transformer.BookingTransformer;
import com.example.GetRide.dto.request.BookingRequest;
import com.example.GetRide.dto.response.BookingResponse;
import com.example.GetRide.exception.CabNotAvailableException;
import com.example.GetRide.exception.CustomerNotFoundException;
import com.example.GetRide.model.Booking;
import com.example.GetRide.model.Cab;
import com.example.GetRide.model.Customer;
import com.example.GetRide.model.Driver;
import com.example.GetRide.repository.BookingRepository;
import com.example.GetRide.repository.CabRepository;
import com.example.GetRide.repository.CustomerRepository;
import com.example.GetRide.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    BookingRepository bookingRepository;

    public BookingResponse bookCab(BookingRequest bookingRequest) {
        Customer customer = customerRepository.findByEmailId(bookingRequest.getCustomerEmail());
        if(ObjectUtils.isEmpty(customer)){
            throw new CustomerNotFoundException("Invalid Email Id");
        }

        Optional<Cab> optionalCab = cabRepository.getRandomAvailableCab();
        if (optionalCab.isEmpty()){
            throw new CabNotAvailableException("Seems like all the drivers are busy");
        }

        Cab cab = optionalCab.get();
        Driver driver = cab.getDriver();
        cab.setBooked(true);

        //booking entity
        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest,cab);
        booking.setCustomer(customer);
        booking.setDriver(driver);
        Booking savedBooking = bookingRepository.save(booking);

        //set remaining attributes
        customer.getBooking().add(savedBooking);
        cab.getDriver().getBooking().add(savedBooking);


        //save
        customerRepository.save(customer); //customer+booking
        driverRepository.save(driver); //driver + booking

        //prepare response dto dto--> response
        return BookingTransformer.bookingToBookingResponse(savedBooking);
    }
}
