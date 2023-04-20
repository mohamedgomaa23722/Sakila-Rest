package com.iti.sakila.api.dtos.categorydtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryRequest {
    @Positive(message = "Category id must be positive number")
    @Min(value = 1, message = "please enter Category id")
    private int categoryId;

    @NotEmpty(message = "Category name can't be null")
    @Size(min = 3, max = 20, message = "Category name must contain 3 to 20 letters")
    private String name;
}
