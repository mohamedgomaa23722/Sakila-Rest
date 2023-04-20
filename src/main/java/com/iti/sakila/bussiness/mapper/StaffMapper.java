package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.dtos.customerdtos.CustomerResponse;
import com.iti.sakila.bussiness.dtos.persondtos.StaffDto;
import com.iti.sakila.persistance.entity.Staff;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "default", uses = {AddressMapper.class, RentalMapper.class})
public interface StaffMapper extends BaseMapper<Staff, StaffDto> {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);
    @Mapping(source = "storeId", target = "store.storeId")
    @Mapping(source = "city", target = "address.city.city")
    @Mapping(source = "country", target = "address.city.country.country")
    @Mapping(source = "address", target = "address.address")
    @Mapping(source = "district", target = "address.district")
    @Mapping(source = "postalCode", target = "address.postalCode")
    @Mapping(source = "phone", target = "address.phone")
    Staff toEntity(StaffDto stuffDto);

    @Mapping(source = "store.storeId", target = "storeId")
    @Mapping(target = "city", source = "address.city.city")
    @Mapping(target = "country", source = "address.city.country.country")
    @Mapping(target = "address", source = "address.address")
    @Mapping(target = "district", source = "address.district")
    @Mapping(target = "postalCode", source = "address.postalCode")
    @Mapping(target = "phone", source = "address.phone")
    StaffDto toDto(Staff staff);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "storeId", target = "store.storeId")
    @Mapping(source = "city", target = "address.city.city")
    @Mapping(source = "country", target = "address.city.country.country")
    @Mapping(source = "address", target = "address.address")
    @Mapping(source = "district", target = "address.district")
    @Mapping(source = "postalCode", target = "address.postalCode")
    @Mapping(source = "phone", target = "address.phone")
    Staff partialUpdate(StaffDto stuffDto, @MappingTarget Staff staff);

    @AfterMapping
    default void linkPayments(@MappingTarget Staff staff) {
        staff.getPayments().forEach(payment -> payment.setStaff(staff));
    }

    @AfterMapping
    default void linkRentals(@MappingTarget Staff staff) {
        staff.getRentals().forEach(rental -> rental.setStaff(staff));
    }

    List<CustomerResponse> toResponseList(List<StaffDto> staffs);

    CustomerResponse toResponse(StaffDto customerDto);
}