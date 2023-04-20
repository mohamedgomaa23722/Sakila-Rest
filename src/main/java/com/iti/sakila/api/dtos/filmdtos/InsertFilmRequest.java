package com.iti.sakila.api.dtos.filmdtos;

import com.iti.sakila.bussiness.dtos.categorydto.CategoryDto;
import com.iti.sakila.bussiness.dtos.filmdtos.FilmActorDto;
import jakarta.validation.constraints.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertFilmRequest implements Serializable {
    private String languageName;
    private String title;
    private String description;
    private int releaseYear;

    private byte rentalDuration;

    private BigDecimal rentalRate;

    private Short length;

    private BigDecimal replacementCost;
    private String specialFeatures;
    private Set<FilmActorDto> actors = new HashSet<>(0);

    @Size(min = 1, message = "please enter at least one category")
    private Set<CategoryDto> categories = new HashSet<>(0);
}
