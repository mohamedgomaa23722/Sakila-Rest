package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.dtos.countrydtos.CountryResponse;
import com.iti.sakila.api.dtos.countrydtos.InsertCountryRequest;
import com.iti.sakila.api.dtos.countrydtos.UpdateCountryRequest;
import com.iti.sakila.bussiness.dtos.countrydtos.CountryCityDto;
import com.iti.sakila.bussiness.dtos.countrydtos.CountryDto;
import com.iti.sakila.persistance.entity.City;
import com.iti.sakila.persistance.entity.Country;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T04:23:17+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class CountryMapperImpl implements CountryMapper {

    @Override
    public List<CountryDto> toDtoList(List<Country> list) {
        if ( list == null ) {
            return null;
        }

        List<CountryDto> list1 = new ArrayList<CountryDto>( list.size() );
        for ( Country country : list ) {
            list1.add( toDto( country ) );
        }

        return list1;
    }

    @Override
    public Country toEntity(CountryDto dto) {
        if ( dto == null ) {
            return null;
        }

        Country country = new Country();

        country.setCountryId( dto.getCountryId() );
        country.setCountry( dto.getCountry() );
        country.setCities( countryCityDtoSetToCitySet( dto.getCities() ) );

        linkCities( country );

        return country;
    }

    @Override
    public CountryDto toDto(Country entity) {
        if ( entity == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        countryDto.setCountryId( entity.getCountryId() );
        countryDto.setCountry( entity.getCountry() );
        countryDto.setCities( citySetToCountryCityDtoSet( entity.getCities() ) );

        return countryDto;
    }

    @Override
    public Country partialUpdate(CountryDto dto, Country entity) {
        if ( dto == null ) {
            return entity;
        }

        if ( dto.getCountryId() != null ) {
            entity.setCountryId( dto.getCountryId() );
        }
        if ( dto.getCountry() != null ) {
            entity.setCountry( dto.getCountry() );
        }
        if ( entity.getCities() != null ) {
            Set<City> set = countryCityDtoSetToCitySet( dto.getCities() );
            if ( set != null ) {
                entity.getCities().clear();
                entity.getCities().addAll( set );
            }
        }
        else {
            Set<City> set = countryCityDtoSetToCitySet( dto.getCities() );
            if ( set != null ) {
                entity.setCities( set );
            }
        }

        linkCities( entity );

        return entity;
    }

    @Override
    public List<CountryResponse> toCountriesResponse(List<CountryDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CountryResponse> list1 = new ArrayList<CountryResponse>( list.size() );
        for ( CountryDto countryDto : list ) {
            list1.add( toCountryResponse( countryDto ) );
        }

        return list1;
    }

    @Override
    public CountryResponse toCountryResponse(CountryDto countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        CountryResponse countryResponse = new CountryResponse();

        countryResponse.setCitiesCount( convertToCityCount( countryDto.getCities() ) );
        countryResponse.setCountryId( countryDto.getCountryId() );
        countryResponse.setCountry( countryDto.getCountry() );

        return countryResponse;
    }

    @Override
    public CountryDto fromInsertCountryRequest(InsertCountryRequest insertCountryRequest) {
        if ( insertCountryRequest == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        countryDto.setCountry( insertCountryRequest.getCountry() );

        return countryDto;
    }

    @Override
    public CountryDto fromUpdateCountryRequest(UpdateCountryRequest updateCountryRequest) {
        if ( updateCountryRequest == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        return countryDto;
    }

    protected City countryCityDtoToCity(CountryCityDto countryCityDto) {
        if ( countryCityDto == null ) {
            return null;
        }

        City city = new City();

        city.setCityId( countryCityDto.getCityId() );
        city.setCity( countryCityDto.getCity() );

        return city;
    }

    protected Set<City> countryCityDtoSetToCitySet(Set<CountryCityDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<City> set1 = new LinkedHashSet<City>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CountryCityDto countryCityDto : set ) {
            set1.add( countryCityDtoToCity( countryCityDto ) );
        }

        return set1;
    }

    protected CountryCityDto cityToCountryCityDto(City city) {
        if ( city == null ) {
            return null;
        }

        CountryCityDto countryCityDto = new CountryCityDto();

        countryCityDto.setCityId( city.getCityId() );
        countryCityDto.setCity( city.getCity() );

        return countryCityDto;
    }

    protected Set<CountryCityDto> citySetToCountryCityDtoSet(Set<City> set) {
        if ( set == null ) {
            return null;
        }

        Set<CountryCityDto> set1 = new LinkedHashSet<CountryCityDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( City city : set ) {
            set1.add( cityToCountryCityDto( city ) );
        }

        return set1;
    }
}
