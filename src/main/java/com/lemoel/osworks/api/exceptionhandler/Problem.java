package com.lemoel.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Problem {

    Integer status;
    LocalDateTime dateTime;
    String title;
    List<Field> fields;

    @Data
    @AllArgsConstructor
    public static class Field {
        private String name;
        private String message;
    }

}
