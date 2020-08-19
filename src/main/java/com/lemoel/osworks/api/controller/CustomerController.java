package com.lemoel.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lemoel.osworks.domain.model.Customer;

@RestController
public class CustomerController {

    @GetMapping("/customers")
    public List<Customer> listar() {
        var customer =  Customer.builder()
                .id(1L)
                .email("lemoel@gmail.com")
                .name("Lemoel Marques")
                .phone("47997286565")
                .build();

        return Arrays.asList(customer);
    }

}
