package com.iti.sakila.api.dtos.countrydtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class UpdateCountryRequest {
    @Positive(message = "Country id must be positive number")
    @Min(value = 1, message = "please enter country id")
    private  Short countryId;
    @NotNull(message = "Please enter country name")
    @Size(min = 4, max = 25, message = "country name must contain 4 to 25 letters")
    private  String country;
}
