package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.bussiness.dtos.languagedtos.LanguageDto;
import com.iti.sakila.persistance.entity.Language;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T04:23:16+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class LanguageMapperImpl implements LanguageMapper {

    @Override
    public List<LanguageDto> toDtoList(List<Language> list) {
        if ( list == null ) {
            return null;
        }

        List<LanguageDto> list1 = new ArrayList<LanguageDto>( list.size() );
        for ( Language language : list ) {
            list1.add( toDto( language ) );
        }

        return list1;
    }

    @Override
    public Language toEntity(LanguageDto dto) {
        if ( dto == null ) {
            return null;
        }

        Language language = new Language();

        language.setLanguageId( dto.getLanguageId() );
        language.setName( dto.getName() );

        return language;
    }

    @Override
    public LanguageDto toDto(Language entity) {
        if ( entity == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        languageDto.setLanguageId( entity.getLanguageId() );
        languageDto.setName( entity.getName() );

        return languageDto;
    }

    @Override
    public Language partialUpdate(LanguageDto dto, Language entity) {
        if ( dto == null ) {
            return entity;
        }

        entity.setLanguageId( dto.getLanguageId() );
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }

        return entity;
    }
}
