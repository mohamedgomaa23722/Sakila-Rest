package com.iti.sakila.bussiness.mapper.actormapper;

import com.iti.sakila.bussiness.dtos.actordto.ActorDto;
import com.iti.sakila.bussiness.dtos.actordto.ActorFilmDto;
import com.iti.sakila.persistance.entity.Actor;
import com.iti.sakila.persistance.entity.FilmActor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T04:23:16+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class ActorMapperImpl implements ActorMapper {

    private final ActorFilmMapper actorFilmMapper = ActorFilmMapper.INSTANCE;

    @Override
    public List<ActorDto> toDtoList(List<Actor> list) {
        if ( list == null ) {
            return null;
        }

        List<ActorDto> list1 = new ArrayList<ActorDto>( list.size() );
        for ( Actor actor : list ) {
            list1.add( toDto( actor ) );
        }

        return list1;
    }

    @Override
    public ActorDto toDto(Actor entity) {
        if ( entity == null ) {
            return null;
        }

        ActorDto actorDto = new ActorDto();

        actorDto.setFilms( filmActorSetToActorFilmDtoSet( entity.getFilmActors() ) );
        actorDto.setActorId( entity.getActorId() );
        actorDto.setFirstName( entity.getFirstName() );
        actorDto.setLastName( entity.getLastName() );

        return actorDto;
    }

    @Override
    public Actor partialUpdate(ActorDto dto, Actor entity) {
        if ( dto == null ) {
            return entity;
        }

        if ( entity.getFilmActors() != null ) {
            Set<FilmActor> set = actorFilmDtoSetToFilmActorSet( dto.getFilms() );
            if ( set != null ) {
                entity.getFilmActors().clear();
                entity.getFilmActors().addAll( set );
            }
        }
        else {
            Set<FilmActor> set = actorFilmDtoSetToFilmActorSet( dto.getFilms() );
            if ( set != null ) {
                entity.setFilmActors( set );
            }
        }
        if ( dto.getActorId() != null ) {
            entity.setActorId( dto.getActorId() );
        }
        if ( dto.getFirstName() != null ) {
            entity.setFirstName( dto.getFirstName() );
        }
        if ( dto.getLastName() != null ) {
            entity.setLastName( dto.getLastName() );
        }

        linkActorFilms( entity );

        return entity;
    }

    @Override
    public Actor toEntity(ActorDto actorDto) {
        if ( actorDto == null ) {
            return null;
        }

        Actor actor = new Actor();

        actor.setFilmActors( actorFilmDtoSetToFilmActorSet( actorDto.getFilms() ) );
        actor.setActorId( actorDto.getActorId() );
        actor.setFirstName( actorDto.getFirstName() );
        actor.setLastName( actorDto.getLastName() );

        linkActorFilms( actor );

        return actor;
    }

    protected Set<ActorFilmDto> filmActorSetToActorFilmDtoSet(Set<FilmActor> set) {
        if ( set == null ) {
            return null;
        }

        Set<ActorFilmDto> set1 = new LinkedHashSet<ActorFilmDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FilmActor filmActor : set ) {
            set1.add( actorFilmMapper.toDto( filmActor ) );
        }

        return set1;
    }

    protected Set<FilmActor> actorFilmDtoSetToFilmActorSet(Set<ActorFilmDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<FilmActor> set1 = new LinkedHashSet<FilmActor>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ActorFilmDto actorFilmDto : set ) {
            set1.add( actorFilmMapper.toEntity( actorFilmDto ) );
        }

        return set1;
    }
}
