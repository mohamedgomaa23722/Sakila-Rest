package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.dtos.customerdtos.CustomerResponse;
import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.bussiness.dtos.persondtos.CustomerDto;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import com.iti.sakila.persistance.entity.Customer;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Mapper(componentModel = "default", uses = {AddressMapper.class, RentalMapper.class})
public interface CustomerMapper extends BaseMapper<Customer, CustomerDto> {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "storeId", target = "store.storeId")
    @Mapping(source = "city", target = "address.city.city")
    @Mapping(source = "country", target = "address.city.country.country")
    @Mapping(source = "address", target = "address.address")
    @Mapping(source = "district", target = "address.district")
    @Mapping(source = "postalCode", target = "address.postalCode")
    @Mapping(source = "phone", target = "address.phone")
    Customer toEntity(CustomerDto customerDto);

    @Mapping(source = "store.storeId", target = "storeId")
    @Mapping(target = "city", source = "address.city.city")
    @Mapping(target = "country", source = "address.city.country.country")
    @Mapping(target = "address", source = "address.address")
    @Mapping(target = "district", source = "address.district")
    @Mapping(target = "postalCode", source = "address.postalCode")
    @Mapping(target = "phone", source = "address.phone")
    CustomerDto toDto(Customer customer);

    @Mapping(target = "paymentsAmount", source = "payments", qualifiedByName = "paymentAmount")
    @Mapping(target = "rentAmount", source = "rentals", qualifiedByName = "rentalAmount")
    CustomerResponse toResponse(CustomerDto customers);

    List<CustomerResponse> toResponseList(List<CustomerDto> customers);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "storeId", target = "store.storeId")
    @Mapping(source = "city", target = "address.city.city")
    @Mapping(source = "country", target = "address.city.country.country")
    @Mapping(source = "address", target = "address.address")
    @Mapping(source = "district", target = "address.district")
    @Mapping(source = "postalCode", target = "address.postalCode")
    @Mapping(source = "phone", target = "address.phone")
    Customer partialUpdate(CustomerDto customerDto, @MappingTarget Customer customer);

    @AfterMapping
    default void linkPayments(@MappingTarget Customer customer) {
        customer.getPayments().forEach(payment -> payment.setCustomer(customer));
    }

    @AfterMapping
    default void linkRentals(@MappingTarget Customer customer) {
        customer.getRentals().forEach(rental -> rental.setCustomer(customer));
    }

    @Named("paymentAmount")
    default String convertToString(Set<PaymentDto> payments) {
        Optional<BigDecimal> amount = payments.stream()
                .map(PaymentDto::getAmount)
                .reduce(BigDecimal::add);
        if (amount.isPresent())
            return amount.get().toString();
        else
            return "0";
    }

    @Named("rentalAmount")
    default int convertToRentalAmount(Set<RentDto> rentals) {
        return rentals.size();
    }
}