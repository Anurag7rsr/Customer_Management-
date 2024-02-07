package com.customer_Management.service.impl;

import com.customer_Management.entity.Customer;
import com.customer_Management.payload.CustomerDto;
import com.customer_Management.repository.CustomerRepository;
import com.customer_Management.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer createCustomer(CustomerDto customerDto) {//1
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id) {
        Optional<Customer> optional = customerRepository.findById(id);
        Customer customer = null;
        if (optional.isPresent()) {
            customer = optional.get();
        } else {
            throw new RuntimeException(" Customer not found for id :: " + id);
        }
        return customer;
    }


    @Override
    public void deleteCustomer(Long id) {

        customerRepository.deleteById(id);
    }


    @Override
    public void saveCustomer(Customer customer) {

        customerRepository.save(customer);
    }

    @Override
    public Customer findByEmail(String email) {

        return customerRepository.findByEmail(email);
    }

}

