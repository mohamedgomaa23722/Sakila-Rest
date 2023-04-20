package com.iti.sakila.bussiness.dtos.actordto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class ActorDto implements Serializable {
    @Positive(message = "Please Enter positive id")
    private Short actorId;
    @NotNull(message = "must enter actor first name")
    private String firstName;
    @NotNull(message = "must enter actor last name")
    private String lastName;
    private Set<ActorFilmDto> films = new HashSet<>(0);
}