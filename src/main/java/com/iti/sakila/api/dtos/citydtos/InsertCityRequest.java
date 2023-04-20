package com.iti.sakila.api.dtos.citydtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertCityRequest {
    @NotNull(message = "Please enter country name")
    @Size(min = 4, max = 25, message = "country name must contain 4 to 25 letters")
    private  String country;
    @NotNull(message = "Please enter city name")
    @Size(min = 4, max = 25, message = "city name must contain 4 to 25 letters")
    private  String city;
}
