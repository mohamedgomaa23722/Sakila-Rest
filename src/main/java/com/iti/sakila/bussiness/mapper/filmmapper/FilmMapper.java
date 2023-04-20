package com.iti.sakila.bussiness.mapper.filmmapper;

import com.iti.sakila.api.dtos.filmdtos.InsertFilmRequest;
import com.iti.sakila.bussiness.dtos.filmdtos.FilmDto;
import com.iti.sakila.bussiness.mapper.BaseMapper;
import com.iti.sakila.persistance.entity.Film;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "default", uses = {FilmActorMapper.class, FilmCategoryMapper.class})
public interface FilmMapper extends BaseMapper<Film, FilmDto> {
    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);
    @Mapping(source = "actors", target = "filmActors")
    @Mapping(source = "categories", target = "filmCategories")
    @Mapping(source = "languageName", target = "languageByLanguageId.name")
    Film toEntity(FilmDto filmDto);

    FilmDto fromInsertFilmRequest(InsertFilmRequest insertFilmRequest);

    @AfterMapping
    default void linkFilmActors(@MappingTarget Film film) {
        film.getFilmActors().forEach(filmActor -> filmActor.setFilm(film));
    }
    @AfterMapping
    default void linkFilmCategories(@MappingTarget Film film) {
        film.getFilmCategories().forEach(filmCategory -> filmCategory.setFilm(film));
    }
}