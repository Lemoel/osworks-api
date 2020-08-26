package com.lemoel.osworks.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lemoel.osworks.domain.ValidationGroups;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.CustomerId.class)
    @ManyToOne
    Customer customer;

    @NotNull
    String description;

    @NotNull
    BigDecimal cost;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    StatusWorkOrder status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    OffsetDateTime dateOpen;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    OffsetDateTime dateFinished;

}
