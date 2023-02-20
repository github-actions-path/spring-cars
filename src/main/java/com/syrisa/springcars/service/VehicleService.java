package com.syrisa.springcars.service;

import com.syrisa.springcars.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface VehicleService<T extends Vehicle> {
    T createVehicle(T t);
    T updateVehicle(T t);
    String deleteVehicle(T t);
    T getVehicleByVehicleID(UUID uuid);
    List<T> getVehicles();
}
