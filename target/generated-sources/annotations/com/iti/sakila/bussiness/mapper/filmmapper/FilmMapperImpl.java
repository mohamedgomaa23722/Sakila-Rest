package com.iti.sakila.bussiness.mapper.filmmapper;

import com.iti.sakila.api.dtos.filmdtos.InsertFilmRequest;
import com.iti.sakila.bussiness.dtos.categorydto.CategoryDto;
import com.iti.sakila.bussiness.dtos.filmdtos.FilmActorDto;
import com.iti.sakila.bussiness.dtos.filmdtos.FilmDto;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.persistance.entity.FilmActor;
import com.iti.sakila.persistance.entity.FilmCategory;
import com.iti.sakila.persistance.entity.Language;
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
public class FilmMapperImpl implements FilmMapper {

    private final FilmActorMapper filmActorMapper = FilmActorMapper.INSTANCE;
    private final FilmCategoryMapper filmCategoryMapper = FilmCategoryMapper.INSTANCE;

    @Override
    public List<FilmDto> toDtoList(List<Film> list) {
        if ( list == null ) {
            return null;
        }

        List<FilmDto> list1 = new ArrayList<FilmDto>( list.size() );
        for ( Film film : list ) {
            list1.add( toDto( film ) );
        }

        return list1;
    }

    @Override
    public FilmDto toDto(Film entity) {
        if ( entity == null ) {
            return null;
        }

        FilmDto filmDto = new FilmDto();

        filmDto.setActors( filmActorSetToFilmActorDtoSet( entity.getFilmActors() ) );
        filmDto.setCategories( filmCategorySetToCategoryDtoSet( entity.getFilmCategories() ) );
        filmDto.setLanguageName( entityLanguageByLanguageIdName( entity ) );
        filmDto.setFilmId( entity.getFilmId() );
        filmDto.setTitle( entity.getTitle() );
        filmDto.setDescription( entity.getDescription() );
        filmDto.setReleaseYear( entity.getReleaseYear() );
        filmDto.setRentalDuration( entity.getRentalDuration() );
        filmDto.setRentalRate( entity.getRentalRate() );
        filmDto.setLength( entity.getLength() );
        filmDto.setReplacementCost( entity.getReplacementCost() );
        filmDto.setSpecialFeatures( entity.getSpecialFeatures() );

        return filmDto;
    }

    @Override
    public Film partialUpdate(FilmDto dto, Film entity) {
        if ( dto == null ) {
            return entity;
        }

        if ( entity.getLanguageByLanguageId() == null ) {
            entity.setLanguageByLanguageId( new Language() );
        }
        filmDtoToLanguage( dto, entity.getLanguageByLanguageId() );
        if ( entity.getFilmActors() != null ) {
            Set<FilmActor> set = filmActorDtoSetToFilmActorSet( dto.getActors() );
            if ( set != null ) {
                entity.getFilmActors().clear();
                entity.getFilmActors().addAll( set );
            }
        }
        else {
            Set<FilmActor> set = filmActorDtoSetToFilmActorSet( dto.getActors() );
            if ( set != null ) {
                entity.setFilmActors( set );
            }
        }
        if ( entity.getFilmCategories() != null ) {
            Set<FilmCategory> set1 = categoryDtoSetToFilmCategorySet( dto.getCategories() );
            if ( set1 != null ) {
                entity.getFilmCategories().clear();
                entity.getFilmCategories().addAll( set1 );
            }
        }
        else {
            Set<FilmCategory> set1 = categoryDtoSetToFilmCategorySet( dto.getCategories() );
            if ( set1 != null ) {
                entity.setFilmCategories( set1 );
            }
        }
        if ( dto.getFilmId() != null ) {
            entity.setFilmId( dto.getFilmId() );
        }
        if ( dto.getTitle() != null ) {
            entity.setTitle( dto.getTitle() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        entity.setReleaseYear( dto.getReleaseYear() );
        entity.setRentalDuration( dto.getRentalDuration() );
        if ( dto.getRentalRate() != null ) {
            entity.setRentalRate( dto.getRentalRate() );
        }
        if ( dto.getLength() != null ) {
            entity.setLength( dto.getLength() );
        }
        if ( dto.getReplacementCost() != null ) {
            entity.setReplacementCost( dto.getReplacementCost() );
        }
        if ( dto.getSpecialFeatures() != null ) {
            entity.setSpecialFeatures( dto.getSpecialFeatures() );
        }

        linkFilmActors( entity );
        linkFilmCategories( entity );

        return entity;
    }

    @Override
    public Film toEntity(FilmDto filmDto) {
        if ( filmDto == null ) {
            return null;
        }

        Film film = new Film();

        film.setLanguageByLanguageId( filmDtoToLanguage1( filmDto ) );
        film.setFilmActors( filmActorDtoSetToFilmActorSet( filmDto.getActors() ) );
        film.setFilmCategories( categoryDtoSetToFilmCategorySet( filmDto.getCategories() ) );
        film.setFilmId( filmDto.getFilmId() );
        film.setTitle( filmDto.getTitle() );
        film.setDescription( filmDto.getDescription() );
        film.setReleaseYear( filmDto.getReleaseYear() );
        film.setRentalDuration( filmDto.getRentalDuration() );
        film.setRentalRate( filmDto.getRentalRate() );
        film.setLength( filmDto.getLength() );
        film.setReplacementCost( filmDto.getReplacementCost() );
        film.setSpecialFeatures( filmDto.getSpecialFeatures() );

        linkFilmActors( film );
        linkFilmCategories( film );

        return film;
    }

    @Override
    public FilmDto fromInsertFilmRequest(InsertFilmRequest insertFilmRequest) {
        if ( insertFilmRequest == null ) {
            return null;
        }

        FilmDto filmDto = new FilmDto();

        filmDto.setLanguageName( insertFilmRequest.getLanguageName() );
        filmDto.setTitle( insertFilmRequest.getTitle() );
        filmDto.setDescription( insertFilmRequest.getDescription() );
        filmDto.setReleaseYear( insertFilmRequest.getReleaseYear() );
        filmDto.setRentalDuration( insertFilmRequest.getRentalDuration() );
        filmDto.setRentalRate( insertFilmRequest.getRentalRate() );
        filmDto.setLength( insertFilmRequest.getLength() );
        filmDto.setReplacementCost( insertFilmRequest.getReplacementCost() );
        filmDto.setSpecialFeatures( insertFilmRequest.getSpecialFeatures() );
        Set<FilmActorDto> set = insertFilmRequest.getActors();
        if ( set != null ) {
            filmDto.setActors( new LinkedHashSet<FilmActorDto>( set ) );
        }
        Set<CategoryDto> set1 = insertFilmRequest.getCategories();
        if ( set1 != null ) {
            filmDto.setCategories( new LinkedHashSet<CategoryDto>( set1 ) );
        }

        return filmDto;
    }

    protected Set<FilmActorDto> filmActorSetToFilmActorDtoSet(Set<FilmActor> set) {
        if ( set == null ) {
            return null;
        }

        Set<FilmActorDto> set1 = new LinkedHashSet<FilmActorDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FilmActor filmActor : set ) {
            set1.add( filmActorMapper.toDto( filmActor ) );
        }

        return set1;
    }

    protected Set<CategoryDto> filmCategorySetToCategoryDtoSet(Set<FilmCategory> set) {
        if ( set == null ) {
            return null;
        }

        Set<CategoryDto> set1 = new LinkedHashSet<CategoryDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FilmCategory filmCategory : set ) {
            set1.add( filmCategoryMapper.toDto( filmCategory ) );
        }

        return set1;
    }

    private String entityLanguageByLanguageIdName(Film film) {
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

    protected void filmDtoToLanguage(FilmDto filmDto, Language mappingTarget) {
        if ( filmDto == null ) {
            return;
        }

        if ( filmDto.getLanguageName() != null ) {
            mappingTarget.setName( filmDto.getLanguageName() );
        }
    }

    protected FilmActor filmActorDtoToFilmActor(FilmActorDto filmActorDto) {
        if ( filmActorDto == null ) {
            return null;
        }

        FilmActor filmActor = new FilmActor();

        return filmActor;
    }

    protected Set<FilmActor> filmActorDtoSetToFilmActorSet(Set<FilmActorDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<FilmActor> set1 = new LinkedHashSet<FilmActor>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FilmActorDto filmActorDto : set ) {
            set1.add( filmActorDtoToFilmActor( filmActorDto ) );
        }

        return set1;
    }

    protected FilmCategory categoryDtoToFilmCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        FilmCategory filmCategory = new FilmCategory();

        return filmCategory;
    }

    protected Set<FilmCategory> categoryDtoSetToFilmCategorySet(Set<CategoryDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<FilmCategory> set1 = new LinkedHashSet<FilmCategory>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CategoryDto categoryDto : set ) {
            set1.add( categoryDtoToFilmCategory( categoryDto ) );
        }

        return set1;
    }

    protected Language filmDtoToLanguage1(FilmDto filmDto) {
        if ( filmDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setName( filmDto.getLanguageName() );

        return language;
    }
}
