package com.iti.sakila.bussiness.mapper.actormapper;

import com.iti.sakila.bussiness.dtos.actordto.ActorFilmDto;
import com.iti.sakila.bussiness.dtos.filmdtos.FilmActorDto;
import com.iti.sakila.bussiness.mapper.BaseMapper;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.persistance.entity.FilmActor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

@Mapper(componentModel = "default")
public interface ActorFilmMapper extends BaseMapper<FilmActor, ActorFilmDto> {
    ActorFilmMapper INSTANCE = Mappers.getMapper(ActorFilmMapper.class);

    @Mapping(source = "film.languageByLanguageId.name", target = "languageName")
    @Mapping(source = "film.filmId", target = "filmId")
    @Mapping(source = "film.title", target = "title")
    @Mapping(source = "film.description", target = "description")
    @Mapping(source = "film.releaseYear", target = "releaseYear")
    @Mapping(source = "film.rentalDuration", target = "rentalDuration")
    @Mapping(source = "film.rentalRate", target = "rentalRate")
    @Mapping(source = "film.length", target = "length")
    @Mapping(source = "film.replacementCost", target = "replacementCost")
    @Mapping(source = "film.specialFeatures", target = "specialFeatures")
    ActorFilmDto toDto(FilmActor filmActor);
}
