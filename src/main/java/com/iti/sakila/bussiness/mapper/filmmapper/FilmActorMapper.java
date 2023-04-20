package com.iti.sakila.bussiness.mapper.filmmapper;

import com.iti.sakila.bussiness.dtos.filmdtos.FilmActorDto;
import com.iti.sakila.bussiness.dtos.filmdtos.FilmDto;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.persistance.entity.FilmActor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "default")
public interface FilmActorMapper {
    FilmActorMapper INSTANCE = Mappers.getMapper(FilmActorMapper.class);
    @Mapping(source = "actor.actorId", target = "actorActorId")
    @Mapping(source = "actor.firstName", target = "actorFirstName")
    @Mapping(source = "actor.lastName", target = "actorLastName")
    FilmActorDto toDto(FilmActor filmActor);

    @Mapping(source = "film.filmId", target = "id.filmId")
    @Mapping(source = "actor.actorActorId", target = "id.actorId")
    @Mapping(source = "actor.actorActorId",target = "actor.actorId")
    @Mapping(source = "film.filmId",target = "film.filmId")
    FilmActor from(FilmActorDto actor, Film film);
}
