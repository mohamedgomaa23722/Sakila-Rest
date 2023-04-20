package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.dtos.citydtos.InsertCityRequest;
import com.iti.sakila.api.dtos.citydtos.UpdateCityRequest;
import com.iti.sakila.bussiness.dtos.addressdtos.CityDto;
import com.iti.sakila.persistance.entity.City;
import com.iti.sakila.persistance.entity.Country;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T04:23:16+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class CityMapperImpl implements CityMapper {

    @Override
    public List<CityDto> toDtoList(List<City> list) {
        if ( list == null ) {
            return null;
        }

        List<CityDto> list1 = new ArrayList<CityDto>( list.size() );
        for ( City city : list ) {
            list1.add( toDto( city ) );
        }

        return list1;
    }

    @Override
    public City partialUpdate(CityDto dto, City entity) {
        if ( dto == null ) {
            return entity;
        }

        if ( entity.getCountry() == null ) {
            entity.setCountry( new Country() );
        }
        cityDtoToCountry( dto, entity.getCountry() );
        if ( dto.getCityId() != null ) {
            entity.setCityId( dto.getCityId() );
        }
        if ( dto.getCity() != null ) {
            entity.setCity( dto.getCity() );
        }

        return entity;
    }

    @Override
    public CityDto toDto(City City) {
        if ( City == null ) {
            return null;
        }

        CityDto cityDto = new CityDto();

        cityDto.setCountry( cityCountryCountry( City ) );
        cityDto.setCityId( City.getCityId() );
        cityDto.setCity( City.getCity() );

        return cityDto;
    }

    @Override
    public City toEntity(CityDto city) {
        if ( city == null ) {
            return null;
        }

        City city1 = new City();

        city1.setCountry( cityDtoToCountry1( city ) );
        city1.setCityId( city.getCityId() );
        city1.setCity( city.getCity() );

        return city1;
    }

    @Override
    public CityDto fromInsertCityRequest(InsertCityRequest insertCityRequest) {
        if ( insertCityRequest == null ) {
            return null;
        }

        CityDto cityDto = new CityDto();

        cityDto.setCountry( insertCityRequest.getCountry() );
        cityDto.setCity( insertCityRequest.getCity() );

        return cityDto;
    }

    @Override
    public CityDto fromUpdateCityRequest(UpdateCityRequest updateCityRequest) {
        if ( updateCityRequest == null ) {
            return null;
        }

        CityDto cityDto = new CityDto();

        cityDto.setCityId( updateCityRequest.getCityId() );
        cityDto.setCountry( updateCityRequest.getCountry() );
        cityDto.setCity( updateCityRequest.getCity() );

        return cityDto;
    }

    protected void cityDtoToCountry(CityDto cityDto, Country mappingTarget) {
        if ( cityDto == null ) {
            return;
        }

        if ( cityDto.getCountry() != null ) {
            mappingTarget.setCountry( cityDto.getCountry() );
        }
    }

    private String cityCountryCountry(City city) {
        if ( city == null ) {
            return null;
        }
        Country country = city.getCountry();
        if ( country == null ) {
            return null;
        }
        String country1 = country.getCountry();
        if ( country1 == null ) {
            return null;
        }
        return country1;
    }

    protected Country cityDtoToCountry1(CityDto cityDto) {
        if ( cityDto == null ) {
            return null;
        }

        Country country = new Country();

        country.setCountry( cityDto.getCountry() );

        return country;
    }
}
