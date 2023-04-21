package com.iti.sakila.bussiness.mapper.filmmapper;

import com.iti.sakila.bussiness.dtos.filmdtos.FilmActorDto;
import com.iti.sakila.persistance.entity.Actor;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.persistance.entity.FilmActor;
import com.iti.sakila.persistance.entity.FilmActorId;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T03:51:06+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class FilmActorMapperImpl implements FilmActorMapper {

    @Override
    public FilmActorDto toDto(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }

        FilmActorDto filmActorDto = new FilmActorDto();

        filmActorDto.setActorActorId( filmActorActorActorId( filmActor ) );
        filmActorDto.setActorFirstName( filmActorActorFirstName( filmActor ) );
        filmActorDto.setActorLastName( filmActorActorLastName( filmActor ) );

        return filmActorDto;
    }

    @Override
    public FilmActor from(FilmActorDto actor, Film film) {
        if ( actor == null && film == null ) {
            return null;
        }

        FilmActor filmActor = new FilmActor();

        if ( actor != null ) {
            if ( filmActor.getId() == null ) {
                filmActor.setId( new FilmActorId() );
            }
            filmActorDtoToFilmActorId( actor, filmActor.getId() );
            filmActor.setActor( filmActorDtoToActor( actor ) );
        }
        if ( film != null ) {
            if ( filmActor.getId() == null ) {
                filmActor.setId( new FilmActorId() );
            }
            filmToFilmActorId( film, filmActor.getId() );
            filmActor.setFilm( filmToFilm( film ) );
            filmActor.setLastUpdate( film.getLastUpdate() );
        }

        return filmActor;
    }

    private Short filmActorActorActorId(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }
        Actor actor = filmActor.getActor();
        if ( actor == null ) {
            return null;
        }
        Short actorId = actor.getActorId();
        if ( actorId == null ) {
            return null;
        }
        return actorId;
    }

    private String filmActorActorFirstName(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }
        Actor actor = filmActor.getActor();
        if ( actor == null ) {
            return null;
        }
        String firstName = actor.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String filmActorActorLastName(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }
        Actor actor = filmActor.getActor();
        if ( actor == null ) {
            return null;
        }
        String lastName = actor.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    protected void filmToFilmActorId(Film film, FilmActorId mappingTarget) {
        if ( film == null ) {
            return;
        }

        if ( film.getFilmId() != null ) {
            mappingTarget.setFilmId( film.getFilmId() );
        }
    }

    protected void filmActorDtoToFilmActorId(FilmActorDto filmActorDto, FilmActorId mappingTarget) {
        if ( filmActorDto == null ) {
            return;
        }

        if ( filmActorDto.getActorActorId() != null ) {
            mappingTarget.setActorId( filmActorDto.getActorActorId() );
        }
    }

    protected Actor filmActorDtoToActor(FilmActorDto filmActorDto) {
        if ( filmActorDto == null ) {
            return null;
        }

        Actor actor = new Actor();

        actor.setActorId( filmActorDto.getActorActorId() );

        return actor;
    }

    protected Film filmToFilm(Film film) {
        if ( film == null ) {
            return null;
        }

        Film film1 = new Film();

        film1.setFilmId( film.getFilmId() );

        return film1;
    }
}
