package com.customer_Management.repository;

import com.customer_Management.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
//    @Query("SELECT  FROM customer  WHERE " +
//            "(:email IS NULL OR c.email LIKE %:email%) AND " +
//            "(:city IS NULL OR c.city LIKE %:city%) AND " +
//            "(:firstName IS NULL OR c.firstName LIKE %:firstName%) AND " +
//            "(:phone IS NULL OR c.phone LIKE %:phone%)")
//    List<Customer> searchCustomers(
//            @Param("email") String email,
//            @Param("city") String city,
//            @Param("firstName") String firstName,
//            @Param("phone") String phone);

    Customer findByEmail(String email);
}
