package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.dtos.citydtos.InsertCityRequest;
import com.iti.sakila.api.dtos.citydtos.UpdateCityRequest;
import com.iti.sakila.bussiness.dtos.addressdtos.CityDto;
import com.iti.sakila.persistance.entity.City;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "default")
public interface CityMapper extends BaseMapper<City, CityDto> {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Override
    @Mapping(source = "country.country", target = "country")
    CityDto toDto(City City);

    @Override
    @Mapping(source = "country", target = "country.country")
    City toEntity(CityDto city);

    CityDto fromInsertCityRequest(InsertCityRequest insertCityRequest);

    CityDto fromUpdateCityRequest(UpdateCityRequest updateCityRequest);
}