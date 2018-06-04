package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/init")
    public void initializeDb() {
        customerRepository.save(new Customer("Alex", ""));
        customerRepository.save(new Customer("Ada", ""));
        customerRepository.save(new Customer("Alexandra", ""));
    }

    @GetMapping("/customer")
    public @ResponseBody Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}