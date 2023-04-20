package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.dtos.customerdtos.CustomerRentalResponse;
import com.iti.sakila.api.dtos.rentdtos.UpdateRentRequest;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import com.iti.sakila.persistance.entity.Customer;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.persistance.entity.Inventory;
import com.iti.sakila.persistance.entity.Rental;
import com.iti.sakila.persistance.entity.Staff;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T04:23:16+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class RentalMapperImpl implements RentalMapper {

    @Override
    public List<RentDto> toDtoList(List<Rental> list) {
        if ( list == null ) {
            return null;
        }

        List<RentDto> list1 = new ArrayList<RentDto>( list.size() );
        for ( Rental rental : list ) {
            list1.add( toDto( rental ) );
        }

        return list1;
    }

    @Override
    public Rental partialUpdate(RentDto dto, Rental entity) {
        if ( dto == null ) {
            return entity;
        }

        if ( entity.getCustomer() == null ) {
            entity.setCustomer( new Customer() );
        }
        rentDtoToCustomer( dto, entity.getCustomer() );
        if ( entity.getInventory() == null ) {
            entity.setInventory( new Inventory() );
        }
        rentDtoToInventory( dto, entity.getInventory() );
        if ( entity.getStaff() == null ) {
            entity.setStaff( new Staff() );
        }
        rentDtoToStaff( dto, entity.getStaff() );
        if ( dto.getRentalId() != null ) {
            entity.setRentalId( dto.getRentalId() );
        }
        if ( dto.getRentalDate() != null ) {
            entity.setRentalDate( dto.getRentalDate() );
        }
        if ( dto.getReturnDate() != null ) {
            entity.setReturnDate( dto.getReturnDate() );
        }

        return entity;
    }

    @Override
    public RentDto toDto(Rental entity) {
        if ( entity == null ) {
            return null;
        }

        RentDto rentDto = new RentDto();

        rentDto.setCustomerId( entityCustomerCustomerId( entity ) );
        rentDto.setCustomerName( entityCustomerFirstName( entity ) );
        rentDto.setFilmName( entityInventoryFilmTitle( entity ) );
        Integer inventoryId = entityInventoryInventoryId( entity );
        if ( inventoryId != null ) {
            rentDto.setInventoryId( inventoryId );
        }
        rentDto.setStaffId( entityStaffStaffId( entity ) );
        rentDto.setRentalId( entity.getRentalId() );
        rentDto.setRentalDate( entity.getRentalDate() );
        rentDto.setReturnDate( entity.getReturnDate() );

        return rentDto;
    }

    @Override
    public Rental toEntity(RentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Rental rental = new Rental();

        rental.setCustomer( rentDtoToCustomer1( dto ) );
        rental.setInventory( rentDtoToInventory1( dto ) );
        rental.setStaff( rentDtoToStaff1( dto ) );
        rental.setRentalId( dto.getRentalId() );
        rental.setRentalDate( dto.getRentalDate() );
        rental.setReturnDate( dto.getReturnDate() );

        return rental;
    }

    @Override
    public CustomerRentalResponse toRentalResponse(Rental rental) {
        if ( rental == null ) {
            return null;
        }

        CustomerRentalResponse customerRentalResponse = new CustomerRentalResponse();

        Short customerId = entityCustomerCustomerId( rental );
        if ( customerId != null ) {
            customerRentalResponse.setCustomerId( customerId );
        }
        customerRentalResponse.setCustomerName( entityCustomerFirstName( rental ) );

        return customerRentalResponse;
    }

    @Override
    public RentDto fromRentalRequest(UpdateRentRequest rentalRequest) {
        if ( rentalRequest == null ) {
            return null;
        }

        RentDto rentDto = new RentDto();

        rentDto.setCustomerId( rentalRequest.getCustomerId() );
        rentDto.setRentalId( rentalRequest.getRentalId() );
        rentDto.setRentalDate( rentalRequest.getRentalDate() );
        rentDto.setReturnDate( rentalRequest.getReturnDate() );
        rentDto.setInventoryId( rentalRequest.getInventoryId() );
        rentDto.setStaffId( rentalRequest.getStaffId() );

        return rentDto;
    }

    @Override
    public List<CustomerRentalResponse> toRentalResponseList(List<Rental> rentals) {
        if ( rentals == null ) {
            return null;
        }

        List<CustomerRentalResponse> list = new ArrayList<CustomerRentalResponse>( rentals.size() );
        for ( Rental rental : rentals ) {
            list.add( toRentalResponse( rental ) );
        }

        return list;
    }

    protected void rentDtoToCustomer(RentDto rentDto, Customer mappingTarget) {
        if ( rentDto == null ) {
            return;
        }

        if ( rentDto.getCustomerId() != null ) {
            mappingTarget.setCustomerId( rentDto.getCustomerId() );
        }
        if ( rentDto.getCustomerName() != null ) {
            mappingTarget.setFirstName( rentDto.getCustomerName() );
        }
    }

    protected void rentDtoToFilm(RentDto rentDto, Film mappingTarget) {
        if ( rentDto == null ) {
            return;
        }

        if ( rentDto.getFilmName() != null ) {
            mappingTarget.setTitle( rentDto.getFilmName() );
        }
    }

    protected void rentDtoToInventory(RentDto rentDto, Inventory mappingTarget) {
        if ( rentDto == null ) {
            return;
        }

        if ( mappingTarget.getFilm() == null ) {
            mappingTarget.setFilm( new Film() );
        }
        rentDtoToFilm( rentDto, mappingTarget.getFilm() );
        mappingTarget.setInventoryId( rentDto.getInventoryId() );
    }

    protected void rentDtoToStaff(RentDto rentDto, Staff mappingTarget) {
        if ( rentDto == null ) {
            return;
        }

        mappingTarget.setStaffId( rentDto.getStaffId() );
    }

    private Short entityCustomerCustomerId(Rental rental) {
        if ( rental == null ) {
            return null;
        }
        Customer customer = rental.getCustomer();
        if ( customer == null ) {
            return null;
        }
        Short customerId = customer.getCustomerId();
        if ( customerId == null ) {
            return null;
        }
        return customerId;
    }

    private String entityCustomerFirstName(Rental rental) {
        if ( rental == null ) {
            return null;
        }
        Customer customer = rental.getCustomer();
        if ( customer == null ) {
            return null;
        }
        String firstName = customer.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String entityInventoryFilmTitle(Rental rental) {
        if ( rental == null ) {
            return null;
        }
        Inventory inventory = rental.getInventory();
        if ( inventory == null ) {
            return null;
        }
        Film film = inventory.getFilm();
        if ( film == null ) {
            return null;
        }
        String title = film.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }

    private Integer entityInventoryInventoryId(Rental rental) {
        if ( rental == null ) {
            return null;
        }
        Inventory inventory = rental.getInventory();
        if ( inventory == null ) {
            return null;
        }
        Integer inventoryId = inventory.getInventoryId();
        if ( inventoryId == null ) {
            return null;
        }
        return inventoryId;
    }

    private int entityStaffStaffId(Rental rental) {
        if ( rental == null ) {
            return 0;
        }
        Staff staff = rental.getStaff();
        if ( staff == null ) {
            return 0;
        }
        int staffId = staff.getStaffId();
        return staffId;
    }

    protected Customer rentDtoToCustomer1(RentDto rentDto) {
        if ( rentDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCustomerId( rentDto.getCustomerId() );
        customer.setFirstName( rentDto.getCustomerName() );

        return customer;
    }

    protected Film rentDtoToFilm1(RentDto rentDto) {
        if ( rentDto == null ) {
            return null;
        }

        Film film = new Film();

        film.setTitle( rentDto.getFilmName() );

        return film;
    }

    protected Inventory rentDtoToInventory1(RentDto rentDto) {
        if ( rentDto == null ) {
            return null;
        }

        Inventory inventory = new Inventory();

        inventory.setFilm( rentDtoToFilm1( rentDto ) );
        inventory.setInventoryId( rentDto.getInventoryId() );

        return inventory;
    }

    protected Staff rentDtoToStaff1(RentDto rentDto) {
        if ( rentDto == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setStaffId( rentDto.getStaffId() );

        return staff;
    }
}
