package com.iti.sakila.bussiness.mapper.filmmapper;

import com.iti.sakila.bussiness.dtos.categorydto.CategoryDto;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.persistance.entity.FilmCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "default")
public interface FilmCategoryMapper {
    FilmCategoryMapper INSTANCE = Mappers.getMapper(FilmCategoryMapper.class);
    @Mapping(source = "category.categoryId",target = "categoryId")
    @Mapping(source = "category.name",target = "name")
    CategoryDto toDto(FilmCategory filmCategory);

    @Mapping(source = "category.categoryId",target = "id.categoryId")
    @Mapping(source = "category.categoryId",target = "category.categoryId")
    @Mapping(source = "film.filmId",target = "film.filmId")
    @Mapping(source = "film.filmId", target = "id.filmId")
    FilmCategory toEntity(CategoryDto category, Film film);
}
