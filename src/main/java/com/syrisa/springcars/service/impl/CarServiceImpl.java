package com.syrisa.springcars.service.impl;

import com.syrisa.springcars.entity.Car;
import com.syrisa.springcars.repository.CarRepository;
import com.syrisa.springcars.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car createVehicle(Car car) {
        try{
            return carRepository.createVehicle(car);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @Override
    public Car updateVehicle(Car car) {
        try{
            return carRepository.updateVehicle(car);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @Override
    public String deleteVehicle(Car car) {
        try{
            return carRepository.deleteVehicle(car);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @Override
    public Car getVehicleByVehicleID(UUID uuid) {
        try{
            return carRepository.getVehicleByVehicleID(uuid);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @Override
    public List<Car> getVehicles() {
        try{
            return carRepository.getVehicles();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }
}
