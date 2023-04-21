package com.iti.sakila.bussiness.dtos.addressdtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link com.iti.sakila.persistance.entity.City} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement
public class CityDto implements Serializable {
    private Short cityId;
    @Positive(message = "country id must be positive")
    @Min(value = 1, message = "please Enter country id")
    private int countryId;

    private  String country;
    @NotNull(message = "Please enter city name")
    @Size(min = 4, max = 25, message = "city name must contain 4 to 25 letters")
    private  String city;
}