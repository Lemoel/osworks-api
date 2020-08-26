package com.lemoel.osworks.domain.service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemoel.osworks.domain.exception.BusinessException;
import com.lemoel.osworks.domain.model.Customer;
import com.lemoel.osworks.domain.model.StatusWorkOrder;
import com.lemoel.osworks.domain.model.WorkOrder;
import com.lemoel.osworks.domain.repository.CustomerRepository;
import com.lemoel.osworks.domain.repository.WorkOrderRepository;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManagementWorkOrderService {

    @Autowired
    WorkOrderRepository repository;

    @Autowired
    CustomerRepository customerRepository;

    public WorkOrder create(WorkOrder workOrder) {

        Customer customer = customerRepository.findById(workOrder.getCustomer().getId())
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));

        workOrder.setCustomer(customer);
        workOrder.setStatus(StatusWorkOrder.OPEN);
        workOrder.setDateOpen(OffsetDateTime.now());
        return repository.save(workOrder);
    }

}
