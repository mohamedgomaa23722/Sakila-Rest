package com.iti.sakila.api.dtos.countrydtos;

import com.iti.sakila.bussiness.dtos.countrydtos.CountryCityDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertCountryRequest {
    @NotNull(message = "Please enter country name")
    @Size(min = 4, max = 25, message = "country name must contain 4 to 25 letters")
    private  String country;

    private Set<CountryCityDto> countryCityDtos;
}
