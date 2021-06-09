package com.example.demo.mongoapi.repositories;

import com.example.demo.mongoapi.model.car.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, String> {

    Car findByCarId(String carId);
}
