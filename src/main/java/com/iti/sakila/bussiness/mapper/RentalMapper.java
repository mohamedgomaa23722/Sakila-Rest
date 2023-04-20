package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.dtos.customerdtos.CustomerRentalResponse;
import com.iti.sakila.api.dtos.rentdtos.UpdateRentRequest;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import com.iti.sakila.persistance.entity.Rental;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "default")
public interface RentalMapper extends BaseMapper<Rental, RentDto> {
    RentalMapper INSTANCE = Mappers.getMapper(RentalMapper.class);

    @Mapping(source = "customer.customerId", target = "customerId")
    @Mapping(source = "customer.firstName", target = "customerName")
    @Mapping(source = "inventory.film.title", target = "filmName")
    @Mapping(source = "inventory.inventoryId", target = "inventoryId")
    @Mapping(source = "staff.staffId", target = "staffId")
    @Override
    RentDto toDto(Rental entity);
    @Mapping(target = "customer.customerId", source = "customerId")
    @Mapping(target = "customer.firstName", source = "customerName")
    @Mapping(target = "inventory.film.title", source = "filmName")
    @Mapping(target = "inventory.inventoryId", source = "inventoryId")
    @Mapping(target = "staff.staffId", source = "staffId")
    @Override
    Rental toEntity(RentDto dto);

    @Mapping(source = "customer.customerId", target = "customerId")
    @Mapping(source = "customer.firstName", target = "customerName")
    CustomerRentalResponse toRentalResponse(Rental rental);

    @Mapping(target = "customerId", source = "customerId")
    RentDto fromRentalRequest(UpdateRentRequest rentalRequest);

    List<CustomerRentalResponse> toRentalResponseList(List<Rental> rentals);
}