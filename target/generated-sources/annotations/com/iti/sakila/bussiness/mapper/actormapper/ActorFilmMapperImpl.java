package com.iti.sakila.bussiness.mapper.actormapper;

import com.iti.sakila.bussiness.dtos.actordto.ActorFilmDto;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.persistance.entity.FilmActor;
import com.iti.sakila.persistance.entity.Language;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T03:51:04+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class ActorFilmMapperImpl implements ActorFilmMapper {

    @Override
    public List<ActorFilmDto> toDtoList(List<FilmActor> list) {
        if ( list == null ) {
            return null;
        }

        List<ActorFilmDto> list1 = new ArrayList<ActorFilmDto>( list.size() );
        for ( FilmActor filmActor : list ) {
            list1.add( toDto( filmActor ) );
        }

        return list1;
    }

    @Override
    public FilmActor toEntity(ActorFilmDto dto) {
        if ( dto == null ) {
            return null;
        }

        FilmActor filmActor = new FilmActor();

        return filmActor;
    }

    @Override
    public FilmActor partialUpdate(ActorFilmDto dto, FilmActor entity) {
        if ( dto == null ) {
            return entity;
        }

        return entity;
    }

    @Override
    public ActorFilmDto toDto(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }

        ActorFilmDto actorFilmDto = new ActorFilmDto();

        actorFilmDto.setLanguageName( filmActorFilmLanguageByLanguageIdName( filmActor ) );
        actorFilmDto.setFilmId( filmActorFilmFilmId( filmActor ) );
        actorFilmDto.setTitle( filmActorFilmTitle( filmActor ) );
        actorFilmDto.setDescription( filmActorFilmDescription( filmActor ) );
        actorFilmDto.setReleaseYear( filmActorFilmReleaseYear( filmActor ) );
        actorFilmDto.setRentalDuration( filmActorFilmRentalDuration( filmActor ) );
        actorFilmDto.setRentalRate( filmActorFilmRentalRate( filmActor ) );
        actorFilmDto.setLength( filmActorFilmLength( filmActor ) );
        actorFilmDto.setReplacementCost( filmActorFilmReplacementCost( filmActor ) );
        actorFilmDto.setSpecialFeatures( filmActorFilmSpecialFeatures( filmActor ) );

        return actorFilmDto;
    }

    private String filmActorFilmLanguageByLanguageIdName(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }
        Film film = filmActor.getFilm();
        if ( film == null ) {
            return null;
        }
        Language languageByLanguageId = film.getLanguageByLanguageId();
        if ( languageByLanguageId == null ) {
            return null;
        }
        String name = languageByLanguageId.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Short filmActorFilmFilmId(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }
        Film film = filmActor.getFilm();
        if ( film == null ) {
            return null;
        }
        Short filmId = film.getFilmId();
        if ( filmId == null ) {
            return null;
        }
        return filmId;
    }

    private String filmActorFilmTitle(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }
        Film film = filmActor.getFilm();
        if ( film == null ) {
            return null;
        }
        String title = film.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }

    private String filmActorFilmDescription(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }
        Film film = filmActor.getFilm();
        if ( film == null ) {
            return null;
        }
        String description = film.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private int filmActorFilmReleaseYear(FilmActor filmActor) {
        if ( filmActor == null ) {
            return 0;
        }
        Film film = filmActor.getFilm();
        if ( film == null ) {
            return 0;
        }
        int releaseYear = film.getReleaseYear();
        return releaseYear;
    }

    private byte filmActorFilmRentalDuration(FilmActor filmActor) {
        if ( filmActor == null ) {
            return 0;
        }
        Film film = filmActor.getFilm();
        if ( film == null ) {
            return 0;
        }
        byte rentalDuration = film.getRentalDuration();
        return rentalDuration;
    }

    private BigDecimal filmActorFilmRentalRate(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }
        Film film = filmActor.getFilm();
        if ( film == null ) {
            return null;
        }
        BigDecimal rentalRate = film.getRentalRate();
        if ( rentalRate == null ) {
            return null;
        }
        return rentalRate;
    }

    private Short filmActorFilmLength(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }
        Film film = filmActor.getFilm();
        if ( film == null ) {
            return null;
        }
        Short length = film.getLength();
        if ( length == null ) {
            return null;
        }
        return length;
    }

    private BigDecimal filmActorFilmReplacementCost(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }
        Film film = filmActor.getFilm();
        if ( film == null ) {
            return null;
        }
        BigDecimal replacementCost = film.getReplacementCost();
        if ( replacementCost == null ) {
            return null;
        }
        return replacementCost;
    }

    private String filmActorFilmSpecialFeatures(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }
        Film film = filmActor.getFilm();
        if ( film == null ) {
            return null;
        }
        String specialFeatures = film.getSpecialFeatures();
        if ( specialFeatures == null ) {
            return null;
        }
        return specialFeatures;
    }
}
