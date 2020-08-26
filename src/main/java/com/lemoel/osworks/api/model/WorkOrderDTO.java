package com.lemoel.osworks.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.lemoel.osworks.domain.model.StatusWorkOrder;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkOrderDTO {

    Long id;
    CustomerDTO customer;
    String description;
    BigDecimal cost;
    StatusWorkOrder status;
    OffsetDateTime dateOpen;
    OffsetDateTime dateFinished;

}
