package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.bussiness.dtos.addressdtos.AddressDto;
import com.iti.sakila.persistance.entity.Address;
import com.iti.sakila.persistance.entity.City;
import com.iti.sakila.persistance.entity.Country;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T03:51:06+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public List<AddressDto> toDtoList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressDto> list1 = new ArrayList<AddressDto>( list.size() );
        for ( Address address : list ) {
            list1.add( toDto( address ) );
        }

        return list1;
    }

    @Override
    public Address toEntity(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setCity( addressDtoToCity( addressDto ) );
        address.setAddressId( addressDto.getAddressId() );
        address.setAddress( addressDto.getAddress() );
        address.setDistrict( addressDto.getDistrict() );
        address.setPostalCode( addressDto.getPostalCode() );
        address.setPhone( addressDto.getPhone() );

        return address;
    }

    @Override
    public AddressDto toDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setCity( addressCityCity( address ) );
        addressDto.setCountry( addressCityCountryCountry( address ) );
        addressDto.setAddressId( address.getAddressId() );
        addressDto.setAddress( address.getAddress() );
        addressDto.setDistrict( address.getDistrict() );
        addressDto.setPostalCode( address.getPostalCode() );
        addressDto.setPhone( address.getPhone() );

        return addressDto;
    }

    @Override
    public Address partialUpdate(AddressDto addressDto, Address address) {
        if ( addressDto == null ) {
            return address;
        }

        if ( address.getCity() == null ) {
            address.setCity( new City() );
        }
        addressDtoToCity1( addressDto, address.getCity() );
        if ( addressDto.getAddressId() != null ) {
            address.setAddressId( addressDto.getAddressId() );
        }
        if ( addressDto.getAddress() != null ) {
            address.setAddress( addressDto.getAddress() );
        }
        if ( addressDto.getDistrict() != null ) {
            address.setDistrict( addressDto.getDistrict() );
        }
        if ( addressDto.getPostalCode() != null ) {
            address.setPostalCode( addressDto.getPostalCode() );
        }
        if ( addressDto.getPhone() != null ) {
            address.setPhone( addressDto.getPhone() );
        }

        return address;
    }

    protected Country addressDtoToCountry(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Country country = new Country();

        country.setCountry( addressDto.getCountry() );

        return country;
    }

    protected City addressDtoToCity(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        City city = new City();

        city.setCountry( addressDtoToCountry( addressDto ) );
        city.setCity( addressDto.getCity() );

        return city;
    }

    private String addressCityCity(Address address) {
        if ( address == null ) {
            return null;
        }
        City city = address.getCity();
        if ( city == null ) {
            return null;
        }
        String city1 = city.getCity();
        if ( city1 == null ) {
            return null;
        }
        return city1;
    }

    private String addressCityCountryCountry(Address address) {
        if ( address == null ) {
            return null;
        }
        City city = address.getCity();
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

    protected void addressDtoToCountry1(AddressDto addressDto, Country mappingTarget) {
        if ( addressDto == null ) {
            return;
        }

        if ( addressDto.getCountry() != null ) {
            mappingTarget.setCountry( addressDto.getCountry() );
        }
    }

    protected void addressDtoToCity1(AddressDto addressDto, City mappingTarget) {
        if ( addressDto == null ) {
            return;
        }

        if ( mappingTarget.getCountry() == null ) {
            mappingTarget.setCountry( new Country() );
        }
        addressDtoToCountry1( addressDto, mappingTarget.getCountry() );
        if ( addressDto.getCity() != null ) {
            mappingTarget.setCity( addressDto.getCity() );
        }
    }
}
