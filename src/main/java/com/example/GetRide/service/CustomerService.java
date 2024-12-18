package com.example.GetRide.service;

import com.example.GetRide.Enum.Gender;
import com.example.GetRide.Transformer.CustomerTransformer;
import com.example.GetRide.dto.request.CustomerRequest;
import com.example.GetRide.dto.response.CustomerResponse;
import com.example.GetRide.model.Customer;
import com.example.GetRide.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        // converting our dto to entity

        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        Customer savedCustomer =  customerRepository.save(customer);

        // saved entity -> response

        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public CustomerResponse getCustomer(String email) {

        //List<Customer> customerList = customerRepository.findAll();
        Customer savedCustomer = customerRepository.findByEmailId(email);
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers = customerRepository.getAllByGenderAndAgeGreaterThan(gender, age);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customers){
            if(customer.getGender()==gender && customer.getAge()>=age){
                customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
            }
        }
        return customerResponses;
    }

}
