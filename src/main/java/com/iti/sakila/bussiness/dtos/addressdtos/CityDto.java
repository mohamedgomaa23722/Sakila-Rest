package com.iti.sakila.bussiness.dtos.addressdtos;

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
    private String country;
    private String city;
}