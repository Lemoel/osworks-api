package com.lemoel.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Problem {

    Integer status;
    OffsetDateTime dateTime;
    String title;
    List<Field> fields;

    @Data
    @AllArgsConstructor
    public static class Field {
        private String name;
        private String message;
    }

}
