package com.syrisa.springcars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@EqualsAndHashCode(callSuper = true)
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car extends Vehicle{
    private String carColor;
}
