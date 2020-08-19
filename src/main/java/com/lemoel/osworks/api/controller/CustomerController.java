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
                .email("teste@gmail.com")
                .name("Teste Marques")
                .phone("474747474747")
                .build();

        return Arrays.asList(customer);
    }

}
