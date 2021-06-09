package com.example.demo.mongoapi.api.car;


import com.example.demo.mongoapi.api.car.io.CarMapper;
import com.example.demo.mongoapi.api.car.io.CarRequest;
import com.example.demo.mongoapi.api.car.io.CarResponse;
import com.example.demo.mongoapi.api.car.io.CarStatus;
import com.example.demo.mongoapi.business.CarService;
import com.example.demo.mongoapi.model.car.Car;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0/mongoDemo/car")
public class CarController {

    private CarService CarService;
    private com.example.demo.mongoapi.api.car.io.CarMapper CarMapper;

    public CarController(CarService CarService, CarMapper CarMapper) {
        this.CarService = CarService;
        this.CarMapper = CarMapper;
    }

    @GetMapping("/{carId}")
    public CarResponse findCar(@NonNull @PathVariable("carId") String carId) {
        Car car = CarService.findByCarId(carId);
        return CarMapper.toResponse(car);
    }


    @PostMapping("/")
    public CarStatus insert(@NonNull @RequestBody CarRequest carRequest) {
        Car car = CarMapper.fromRequest(carRequest);
        CarService.insert(car);
        return new CarStatus();
    }
}
