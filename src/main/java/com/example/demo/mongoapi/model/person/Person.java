package com.example.demo.mongoapi.model.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
public class Person {

    String personId;
    String firstName;
    String lastName;
    Boolean active;
}
