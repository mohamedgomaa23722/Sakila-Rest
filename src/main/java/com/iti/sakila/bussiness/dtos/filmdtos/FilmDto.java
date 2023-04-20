package com.iti.sakila.bussiness.dtos.filmdtos;

import com.iti.sakila.bussiness.dtos.categorydto.CategoryDto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class FilmDto implements Serializable {
    private Short filmId;
    @NotEmpty(message = "please enter language")
    private String languageName;
    @NotEmpty(message = "please enter film title")
    private String title;
    @NotEmpty(message = "please enter film description")
    private String description;
    @Min(value = 1950, message = "please enter film releaseYear between 1950 to current year")
    @Max(value = 2023, message = "please enter film releaseYear between 1950 to current year")
    private int releaseYear;
    @Min(value = 3, message = "please enter film rentalDuration between 3 to 20 days")
    @Max(value = 20, message = "please enter film rentalDuration between 3 to 20 days")
    private byte rentalDuration;
    @DecimalMax(value = "5.0", message = "please enter film rentalRate between 0 to 5 ")
    @DecimalMin(value = "0.0", message = "please enter film rentalRate between 0 to 5")
    private BigDecimal rentalRate;

    @Positive(message = "Please Enter length with positive Number")
    private Short length;
    @Positive(message = "Please Enter replacementCost with positive Number")
    @DecimalMax(value = "500.0", message = "please enter replacementCost between 10 to 500")
    @DecimalMin(value = "10.0", message = "please enter replacementCost between 10 to 500")
    private BigDecimal replacementCost;
    @Size(min = 0, max = 100, message = "please enter specialFeatures size between 0 to 100 character")
    private String specialFeatures;
    private Set<FilmActorDto> actors = new HashSet<>(0);

    @Size(min = 1, message = "please enter at least one category")
    private Set<CategoryDto> categories = new HashSet<>(0);
}