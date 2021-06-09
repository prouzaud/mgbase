package com.example.demo.mongoapi.model.person;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    String personId;
    String firstName;
    String lastName;
}
