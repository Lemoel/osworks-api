package com.lemoel.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemoel.osworks.domain.exception.BusinessException;
import com.lemoel.osworks.domain.model.Customer;
import com.lemoel.osworks.domain.repository.CustomerRepository;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CrudCustumerService {

    @Autowired
    CustomerRepository repository;

    public Customer save(Customer customer) {

        Customer customerExists = repository.findByEmail(customer.getEmail());

        if (customerExists != null && !customerExists.equals(customer)) {
            throw new BusinessException("Já existe um cliente cadastrado com este e-mail");
        }

        return repository.save(customer);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
