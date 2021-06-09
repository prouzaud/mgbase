package com.example.demo.mongoapi.api.car.io;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarRequest {

    String carId;
    String matriculation;
    String owner;
}
