package com.iti.sakila.bussiness.dtos.filmdtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class FilmActorDto implements Serializable {
    @NotNull(message = "please enter actor id")
    @Positive(message = "Please Enter positive id")
    private  Short actorActorId;
    private  String actorFirstName;
    private  String actorLastName;
}