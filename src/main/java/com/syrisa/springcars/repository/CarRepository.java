package com.syrisa.springcars.repository;

import com.syrisa.springcars.entity.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface CarRepository extends VehicleRepository<Car>{

}
