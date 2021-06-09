package com.example.demo.mongoapi.business;

import com.example.demo.mongoapi.model.car.Car;
import com.example.demo.mongoapi.repositories.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarRepository carRepository;
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car findByCarId(String carId) {
        return carRepository.findByCarId(carId);
    }

    public Car insert(Car car) {
        return carRepository.save(car);
    }
}
