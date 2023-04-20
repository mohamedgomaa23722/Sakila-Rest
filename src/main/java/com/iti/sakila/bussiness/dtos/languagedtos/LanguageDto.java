package com.iti.sakila.bussiness.dtos.languagedtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class LanguageDto implements Serializable {
    @NotNull(message = "please enter actor id")
    @Positive(message = "Please Enter positive id")
    private  int languageId;
    private  String name;
}