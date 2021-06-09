package com.example.demo.mongoapi.model.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "cars")
public class Car {

    @Id
    private String carId;

    private String matriculation;
    private String owner;
}
