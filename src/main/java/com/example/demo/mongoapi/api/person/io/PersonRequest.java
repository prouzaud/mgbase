package com.example.demo.mongoapi.api.person.io;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonRequest {

    String personId;
    String firstName;
    String lastName;
}
