package com.lemoel.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lemoel.osworks.domain.model.Customer;
import com.lemoel.osworks.domain.repository.CustomerRepository;
import com.lemoel.osworks.domain.service.CrudCustumerService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/customers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CrudCustumerService custumerService;

    @GetMapping
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> search(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer add(@Valid @RequestBody Customer customer) {
        return custumerService.save(customer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> update(@PathVariable Long id,
                                           @Valid @RequestBody Customer customer) {
        if (!customerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        customer.setId(id);
        customer = custumerService.save(customer);

        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!customerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        custumerService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
