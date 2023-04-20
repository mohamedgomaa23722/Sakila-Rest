package com.iti.sakila.bussiness.dtos.categorydto;

import com.iti.sakila.bussiness.dtos.filmdtos.FilmDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private int categoryId;
    private String name;
    private Set<FilmDto> films;
}
