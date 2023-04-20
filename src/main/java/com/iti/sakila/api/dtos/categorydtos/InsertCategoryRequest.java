package com.iti.sakila.api.dtos.categorydtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertCategoryRequest {
    @NotEmpty(message = "Category name can't be null")
    @Size(min = 8, max = 20, message = "Category name must contain 8 to 20 letters")
    private String name;
}
