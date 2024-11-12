package com.example.GetRide.repository;

import com.example.GetRide.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByEmailId(String email);

    List<Customer> findByName(String name);

    @Query(value = "select * from customer where gender= :gender and age >= :age",nativeQuery = true)
    public List<Customer> getAllByGenderAndAgeGreaterThan(String gender, int age);
}