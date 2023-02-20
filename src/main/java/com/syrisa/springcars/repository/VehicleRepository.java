package com.syrisa.springcars.repository;

import com.syrisa.springcars.entity.Vehicle;

import java.util.List;
import java.util.UUID;


public interface VehicleRepository<T extends Vehicle> {
    T createVehicle(T t);
    T updateVehicle(T t);
    String deleteVehicle(T t);
    T getVehicleByVehicleID(UUID t);
    List<T> getVehicles();
}
