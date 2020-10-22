package com.example.customerservice.Controller;


import com.example.customerservice.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {

    private final RestTemplate restTemplate;

    @Autowired
    public CustomerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/search")
    public Customer getCustomer(@RequestParam(value = "email") final String email) {
        String url = "http://ADDRESS-SERVICE/customers/address?email=" + email;
        return restTemplate.getForObject(url, Customer.class);
    }
}
