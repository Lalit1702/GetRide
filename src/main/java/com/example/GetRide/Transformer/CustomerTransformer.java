package com.example.GetRide.Transformer;

import com.example.GetRide.dto.request.CustomerRequest;
import com.example.GetRide.dto.response.CustomerResponse;
import com.example.GetRide.model.Customer;

public class CustomerTransformer {
    public static CustomerResponse customerToCustomerResponse(Customer customer){
//        CustomerResponse customerResponse = new CustomerResponse();
//        customerResponse.setGender(customer.getGender());
//        customerResponse.setEmailId(customer.getEmailId());
//        customerResponse.setName(customer.getName());
        CustomerResponse customerResponse = CustomerResponse.builder()
                .gender(customer.getGender())
                .emailId(customer.getEmailId())
                .name(customer.getName())
                .build();
        return customerResponse;
    }
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
 //       Customer customer = new Customer();
//        customer.setAge(customerRequest.getAge());
//        customer.setName(customerRequest.getName());
//        customer.setGender(customerRequest.getGender());
//        customer.setEmailId(customerRequest.getEmailId());

        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender())
                .build();
        return customer;
    }
}
