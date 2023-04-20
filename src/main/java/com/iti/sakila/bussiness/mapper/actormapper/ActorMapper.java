package com.iti.sakila.bussiness.mapper.actormapper;

import com.iti.sakila.bussiness.dtos.actordto.ActorDto;
import com.iti.sakila.bussiness.mapper.BaseMapper;
import com.iti.sakila.persistance.entity.Actor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "default", uses = ActorFilmMapper.class)
public interface ActorMapper extends BaseMapper<Actor, ActorDto> {
    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);
    @Mapping(source = "films", target = "filmActors")
    Actor toEntity(ActorDto actorDto);

    @AfterMapping
    default void linkActorFilms(@MappingTarget Actor actor) {
        actor.getFilmActors().forEach(actorFilm -> actorFilm.setActor(actor));
    }
}