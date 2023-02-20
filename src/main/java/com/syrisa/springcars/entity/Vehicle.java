package com.syrisa.springcars.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.syrisa.springcars.enums.VehicleType;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data

public class Vehicle {
    protected UUID vehicleID;
    protected VehicleType vehicleType;
    protected String vehicleName;
    protected String vehicleBrand;
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate vehicleProductYear;
    protected String vehicleManufacturingSite;
}
