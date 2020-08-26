package com.lemoel.osworks.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lemoel.osworks.api.model.WorkOrderDTO;
import com.lemoel.osworks.domain.model.WorkOrder;
import com.lemoel.osworks.domain.repository.WorkOrderRepository;
import com.lemoel.osworks.domain.service.ManagementWorkOrderService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/workorders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkOrderController {

    @Autowired
    ManagementWorkOrderService managementWorkOrderService;

    @Autowired
    WorkOrderRepository workOrderRepository;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkOrderDTO create(@RequestBody @Valid WorkOrder workOrder) {
        return toDTO(managementWorkOrderService.create(workOrder));
    }

    @GetMapping
    public List<WorkOrderDTO> findAll() {
        return toColletionDTO(workOrderRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<WorkOrderDTO> find(@PathVariable Long id) {
        Optional<WorkOrder> workOrder = workOrderRepository.findById(id);
        if (workOrder.isPresent()) {
            WorkOrderDTO dto = toDTO(workOrder.get());
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    private WorkOrderDTO toDTO(WorkOrder workOrder) {
        return modelMapper.map(workOrder, WorkOrderDTO.class);
    }

    private List<WorkOrderDTO> toColletionDTO(List<WorkOrder> workOrders) {
        return workOrders.stream()
                .map(workOrder -> toDTO(workOrder))
                .collect(Collectors.toList());
    }
}
