package com.syrisa.springcars.repository.impl;

import com.syrisa.springcars.entity.Car;
import com.syrisa.springcars.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
@Component
public class CarRepositoryImpl implements CarRepository {

    private static final Map<UUID,Car> CAR_STORAGE = new HashMap<>();

    @Override
    public Car createVehicle(Car car) {
        car.setVehicleID(UUID.randomUUID());
        if (CAR_STORAGE.containsKey(car.getVehicleID())){
            return CAR_STORAGE.get(car.getVehicleID());
        }
        return CAR_STORAGE.put(car.getVehicleID(),car);
    }

    @Override
    public Car updateVehicle(Car car) {
        if (CAR_STORAGE.containsKey(car.getVehicleID())){
           return CAR_STORAGE.put(car.getVehicleID(),car);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT,car.getVehicleID()+" numbered car already exist");
    }

    @Override
    public String deleteVehicle(Car car) {
        CAR_STORAGE.remove(car.getVehicleID());
        return car.getVehicleID()+" numbered car was removed";
    }

    @Override
    public Car getVehicleByVehicleID(UUID uuid) {
        if (CAR_STORAGE.containsKey(uuid)){
            return CAR_STORAGE.get(uuid);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, uuid+" numbered car does not register on the system");
    }

    @Override
    public List<Car> getVehicles() {
        return new ArrayList<>(CAR_STORAGE.values());
    }
}
