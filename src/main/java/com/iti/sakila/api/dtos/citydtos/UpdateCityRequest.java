package com.iti.sakila.api.dtos.citydtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCityRequest {
    @Positive(message = "City id must be positive number")
    @Min(value = 1, message = "please enter city id")
    private Short cityId;
    @NotNull(message = "Please enter country name")
    @Size(min = 8, max = 25, message = "country name must contain 8 to 25 letters")
    private String country;
    @NotNull(message = "Please enter city name")
    @Size(min = 8, max = 25, message = "city name must contain 8 to 25 letters")
    private String city;
}
