package com.customer_Management.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

        private Long id;
        private String firstName;
        private String lastName;
        private String street;
        private String address;
        private String city;
        private String state;
        private String email;
        private String phone;

        // Constructors, getters, and setters



}
