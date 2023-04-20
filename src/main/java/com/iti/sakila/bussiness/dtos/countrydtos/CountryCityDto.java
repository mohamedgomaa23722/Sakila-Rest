package com.iti.sakila.bussiness.dtos.countrydtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.iti.sakila.persistance.entity.City} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryCityDto implements Serializable {
    private  Short cityId;
    private  String city;
}