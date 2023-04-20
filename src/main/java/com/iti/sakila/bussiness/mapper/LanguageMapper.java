package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.bussiness.dtos.languagedtos.LanguageDto;
import com.iti.sakila.persistance.entity.Language;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "default")
public interface LanguageMapper extends BaseMapper<Language,LanguageDto> {
    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);
}