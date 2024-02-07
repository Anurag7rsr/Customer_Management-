package com.customer_Management.controller;
import com.customer_Management.entity.Customer;
import com.customer_Management.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "index"; // Ensure there's an index.html template
    }

    @GetMapping("/showReg")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer()); // Prepares an empty customer for the form
        return "registration"; // Ensure there's a registration.html template for customer registration
    }

    @PostMapping("/saveReg")
    public String saveRegistration(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customerlist"; // Redirects after saving to avoid duplicate submissions
    }

    @PostMapping("/login")
    public String verifyLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        Customer customer = customerService.findByEmail(email);
        if (customer != null && password.equals(customer.getPassword())) {
            return "redirect:/customerlist"; // Redirects to the customer list upon successful login
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "index"; // Stays on the login page if authentication fails
        }
    }

    @GetMapping("/customerlist")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customerlist"; // Ensure there's a customerlist.html template
    }

    @GetMapping("/editCustomer/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.getCustomerById(id).orElse(null);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "editCustomer"; // Ensure there's an editCustomer.html template
        } else {
            return "redirect:/customerlist"; // Redirects if the customer is not found
        }
    }

    @PostMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable("id") Long id, @ModelAttribute("customer") Customer customerDetails, Model model) {
        if (customerService.getCustomerById(id).isPresent()) {
            customerService.saveCustomer(customerDetails); // Assumes saveCustomer method can handle updates
            return "redirect:/customerlist";
        } else {
            model.addAttribute("error", "Error updating customer");
            return "editCustomer"; // Stay on the page and show error
        }
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customerlist"; // Redirects to the customer list after deletion
    }

}