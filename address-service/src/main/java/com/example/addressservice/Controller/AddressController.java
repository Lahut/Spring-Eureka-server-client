package com.example.addressservice.Controller;

import com.example.addressservice.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "customers")
public class AddressController {
    private final RestTemplate restTemplate;

    @Autowired
    public AddressController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/address")
    public Customer getCustomerAddress(@RequestParam(value = "email") final String email) {
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setAddress("123 Kasetsart University");
        return customer;
    }
}
