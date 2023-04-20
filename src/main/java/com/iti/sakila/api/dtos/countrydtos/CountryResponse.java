package com.iti.sakila.api.dtos.countrydtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryResponse {
    private Short countryId;
    private String country;
    private int citiesCount;
}
