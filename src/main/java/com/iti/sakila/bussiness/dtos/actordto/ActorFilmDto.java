package com.iti.sakila.bussiness.dtos.actordto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class ActorFilmDto implements Serializable {
    private Short filmId;
    private String languageName;
    private String title;
    private String description;
    private int releaseYear;
    private byte rentalDuration;
    private BigDecimal rentalRate;
    private Short length;
    private BigDecimal replacementCost;
    private String specialFeatures;
}
