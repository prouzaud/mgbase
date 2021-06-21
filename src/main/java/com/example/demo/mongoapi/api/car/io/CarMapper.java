package com.example.demo.mongoapi.api.car.io;

import com.example.demo.mongoapi.model.car.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarResponse toResponse(Car car) {
        return new CarResponse(car.getCarId(), car.getMatriculation(), car.getOwner());
    }

    public Car fromRequest(CarRequest carRequest) {
        return new Car(carRequest.getCarId(), carRequest.getMatriculation(), carRequest.getOwner(), true);
    }
}
