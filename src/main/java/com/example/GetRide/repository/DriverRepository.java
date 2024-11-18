package com.example.GetRide.repository;

import com.example.GetRide.model.Driver;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
    Driver findByMobileNo(long mobileNo);

    @Query(value = "select * from driver where age >= :age", nativeQuery = true)
    List<Driver> getDriverAboveAge(int age);

    @Modifying
    @Transactional //creates context All database operations in the method are executed within this transaction.
    //If the method completes successfully, the transaction is committed.
    //If an exception occurs, the transaction is rolled back to ensure no partial changes are applied.
    @Query(value = "update driver set driving_license = :driverLicense where mobile_no = :mobileNO",nativeQuery = true)
    void updateDriverLicense(String driverLicense, long mobileNO);

    @Modifying
    @Transactional
    @Query(value = "update Driver d set d.mobileNo=:newMobNo where d.mobileNo = :oldMobNo")
    void updateDriverMobNo(long newMobNo, long oldMobNo);
}
