package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.dtos.countrydtos.CountryResponse;

import com.iti.sakila.api.dtos.countrydtos.InsertCountryRequest;
import com.iti.sakila.api.dtos.countrydtos.UpdateCountryRequest;
import com.iti.sakila.bussiness.dtos.countrydtos.CountryCityDto;
import com.iti.sakila.bussiness.dtos.countrydtos.CountryDto;

import com.iti.sakila.persistance.entity.Country;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "default")
public interface CountryMapper extends BaseMapper<Country,CountryDto> {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    List<CountryResponse> toCountriesResponse(List<CountryDto> list);

    @Mapping(source = "cities",target = "citiesCount", qualifiedByName = "cityCount")
    CountryResponse toCountryResponse(CountryDto countryDto);

    CountryDto fromInsertCountryRequest(InsertCountryRequest insertCountryRequest);

    CountryDto fromUpdateCountryRequest(UpdateCountryRequest updateCountryRequest);

    @AfterMapping
    default void linkCities(@MappingTarget Country country) {
        country.getCities().forEach(city -> city.setCountry(country));
    }

    @Named("cityCount")
    default int convertToCityCount(Set<CountryCityDto> cities) {
        return cities.size();
    }
}