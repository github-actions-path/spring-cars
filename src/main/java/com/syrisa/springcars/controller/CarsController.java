package com.syrisa.springcars.controller;

import com.syrisa.springcars.entity.Car;
import com.syrisa.springcars.service.CarService;
import com.syrisa.springcars.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarsController {
    private static final List<String> cars = Arrays.asList("BMW","Mercedes","Aston Martin","Bentley");

    private final CarService carService;

    @GetMapping("/get")
    public ResponseEntity<List<String>> getCars(){
        cars.forEach(System.out::println);
        return ResponseEntity.of(Optional.of(cars));
    }

    @PostMapping("/create")
    public ResponseEntity<Car> create(@RequestBody Car car){
       try{
           return ResponseEntity.ok(carService.createVehicle(car));
       }catch (Exception exception){
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
       }
    }
    @PutMapping("/update")
    public ResponseEntity<Car> update(@RequestBody Car car){
        try{
            return ResponseEntity.ok(carService.updateVehicle(car));
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody Car car){
        try{
            return ResponseEntity.ok(carService.deleteVehicle(car));
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Car> getCar(@PathVariable("uuid") UUID uuid){
        try{
            return ResponseEntity.ok(carService.getVehicleByVehicleID(uuid));
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars(){
        try{
            return ResponseEntity.ok(carService.getVehicles());
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }
}
