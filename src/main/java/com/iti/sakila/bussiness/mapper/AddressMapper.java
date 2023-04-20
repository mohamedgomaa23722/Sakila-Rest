package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.bussiness.dtos.addressdtos.AddressDto;
import com.iti.sakila.persistance.entity.Address;
import com.iti.sakila.persistance.entity.FilmActor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "default")
public interface AddressMapper extends BaseMapper<Address, AddressDto> {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    @Mapping(source = "city", target = "city.city")
    @Mapping(source = "country", target = "city.country.country")
    Address toEntity(AddressDto addressDto);

    @InheritInverseConfiguration(name = "toEntity")
    AddressDto toDto(Address address);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Address partialUpdate(AddressDto addressDto, @MappingTarget Address address);

    default List<Timestamp> filmActorsToFilmActorLastUpdates(List<FilmActor> filmActors) {
        return filmActors.stream().map(FilmActor::getLastUpdate).collect(Collectors.toList());
    }

    default List<Timestamp> filmActorsToActorLastUpdates(List<FilmActor> filmActors) {
        return filmActors.stream().map(FilmActor::getLastUpdate).collect(Collectors.toList());
    }

    default Set<Timestamp> filmActorsToFilmLastUpdates(Set<FilmActor> filmActors) {
        return filmActors.stream().map(FilmActor::getLastUpdate).collect(Collectors.toSet());
    }
}