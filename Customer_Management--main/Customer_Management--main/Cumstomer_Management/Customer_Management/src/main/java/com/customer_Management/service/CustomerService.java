package com.customer_Management.service;

import com.customer_Management.entity.Customer;
import com.customer_Management.payload.CustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
//    List<Customer> getAllCustomers();
//
//    Optional<Customer> getCustomerById(Long id);
//
//    Customer createCustomer(CustomerDto customerDto);
//
//    Customer updateCustomer(Long id, CustomerDto customerDto);
//
//    void deleteCustomer(Long id);
//
//
//    void saveCustomer(Customer customer);
//
//    Customer findByEmail(String email);
 //------------------------------------------------------------------------
List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Long id);
    Customer createCustomer(CustomerDto customerDto);
    Customer updateCustomer(Long id);
    void deleteCustomer(Long id);
    void saveCustomer(Customer customer);
    Customer findByEmail(String email);

}
