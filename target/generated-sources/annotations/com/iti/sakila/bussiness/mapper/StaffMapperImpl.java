package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.dtos.customerdtos.StaffResponse;
import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.bussiness.dtos.persondtos.StaffDto;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import com.iti.sakila.persistance.entity.Address;
import com.iti.sakila.persistance.entity.City;
import com.iti.sakila.persistance.entity.Country;
import com.iti.sakila.persistance.entity.Payment;
import com.iti.sakila.persistance.entity.Rental;
import com.iti.sakila.persistance.entity.Staff;
import com.iti.sakila.persistance.entity.Store;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T03:51:05+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class StaffMapperImpl implements StaffMapper {

    private final RentalMapper rentalMapper = RentalMapper.INSTANCE;

    @Override
    public List<StaffDto> toDtoList(List<Staff> list) {
        if ( list == null ) {
            return null;
        }

        List<StaffDto> list1 = new ArrayList<StaffDto>( list.size() );
        for ( Staff staff : list ) {
            list1.add( toDto( staff ) );
        }

        return list1;
    }

    @Override
    public Staff toEntity(StaffDto stuffDto) {
        if ( stuffDto == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setStore( staffDtoToStore( stuffDto ) );
        staff.setAddress( staffDtoToAddress( stuffDto ) );
        staff.setStaffId( stuffDto.getStaffId() );
        staff.setFirstName( stuffDto.getFirstName() );
        staff.setLastName( stuffDto.getLastName() );
        staff.setEmail( stuffDto.getEmail() );
        staff.setActive( stuffDto.isActive() );
        staff.setUsername( stuffDto.getUsername() );
        staff.setPayments( paymentDtoSetToPaymentSet( stuffDto.getPayments() ) );
        staff.setRentals( rentDtoSetToRentalSet( stuffDto.getRentals() ) );

        linkPayments( staff );
        linkRentals( staff );

        return staff;
    }

    @Override
    public StaffDto toDto(Staff staff) {
        if ( staff == null ) {
            return null;
        }

        StaffDto staffDto = new StaffDto();

        Integer storeId = staffStoreStoreId( staff );
        if ( storeId != null ) {
            staffDto.setStoreId( storeId.byteValue() );
        }
        staffDto.setCity( staffAddressCityCity( staff ) );
        staffDto.setCountry( staffAddressCityCountryCountry( staff ) );
        staffDto.setAddress( staffAddressAddress( staff ) );
        staffDto.setDistrict( staffAddressDistrict( staff ) );
        staffDto.setPostalCode( staffAddressPostalCode( staff ) );
        staffDto.setPhone( staffAddressPhone( staff ) );
        staffDto.setFirstName( staff.getFirstName() );
        staffDto.setLastName( staff.getLastName() );
        staffDto.setEmail( staff.getEmail() );
        staffDto.setActive( staff.isActive() );
        staffDto.setPayments( paymentSetToPaymentDtoSet( staff.getPayments() ) );
        staffDto.setRentals( rentalSetToRentDtoSet( staff.getRentals() ) );
        staffDto.setStaffId( staff.getStaffId() );
        staffDto.setUsername( staff.getUsername() );

        return staffDto;
    }

    @Override
    public Staff partialUpdate(StaffDto stuffDto, Staff staff) {
        if ( stuffDto == null ) {
            return staff;
        }

        if ( staff.getStore() == null ) {
            staff.setStore( new Store() );
        }
        staffDtoToStore1( stuffDto, staff.getStore() );
        if ( staff.getAddress() == null ) {
            staff.setAddress( new Address() );
        }
        staffDtoToAddress1( stuffDto, staff.getAddress() );
        staff.setStaffId( stuffDto.getStaffId() );
        if ( stuffDto.getFirstName() != null ) {
            staff.setFirstName( stuffDto.getFirstName() );
        }
        if ( stuffDto.getLastName() != null ) {
            staff.setLastName( stuffDto.getLastName() );
        }
        if ( stuffDto.getEmail() != null ) {
            staff.setEmail( stuffDto.getEmail() );
        }
        staff.setActive( stuffDto.isActive() );
        if ( stuffDto.getUsername() != null ) {
            staff.setUsername( stuffDto.getUsername() );
        }
        if ( staff.getPayments() != null ) {
            Set<Payment> set = paymentDtoSetToPaymentSet( stuffDto.getPayments() );
            if ( set != null ) {
                staff.getPayments().clear();
                staff.getPayments().addAll( set );
            }
        }
        else {
            Set<Payment> set = paymentDtoSetToPaymentSet( stuffDto.getPayments() );
            if ( set != null ) {
                staff.setPayments( set );
            }
        }
        if ( staff.getRentals() != null ) {
            Set<Rental> set1 = rentDtoSetToRentalSet( stuffDto.getRentals() );
            if ( set1 != null ) {
                staff.getRentals().clear();
                staff.getRentals().addAll( set1 );
            }
        }
        else {
            Set<Rental> set1 = rentDtoSetToRentalSet( stuffDto.getRentals() );
            if ( set1 != null ) {
                staff.setRentals( set1 );
            }
        }

        linkPayments( staff );
        linkRentals( staff );

        return staff;
    }

    @Override
    public List<StaffResponse> toResponseList(List<StaffDto> staffs) {
        if ( staffs == null ) {
            return null;
        }

        List<StaffResponse> list = new ArrayList<StaffResponse>( staffs.size() );
        for ( StaffDto staffDto : staffs ) {
            list.add( toResponse( staffDto ) );
        }

        return list;
    }

    @Override
    public StaffResponse toResponse(StaffDto customers) {
        if ( customers == null ) {
            return null;
        }

        StaffResponse staffResponse = new StaffResponse();

        staffResponse.setPaymentsAmount( convertToString( customers.getPayments() ) );
        staffResponse.setRentAmount( convertToRentalAmount( customers.getRentals() ) );
        staffResponse.setFirstName( customers.getFirstName() );
        staffResponse.setLastName( customers.getLastName() );
        staffResponse.setStoreId( customers.getStoreId() );
        staffResponse.setEmail( customers.getEmail() );
        staffResponse.setPhone( customers.getPhone() );
        staffResponse.setCountry( customers.getCountry() );
        staffResponse.setCity( customers.getCity() );
        staffResponse.setAddress( customers.getAddress() );
        staffResponse.setDistrict( customers.getDistrict() );
        staffResponse.setPostalCode( customers.getPostalCode() );
        staffResponse.setCreateDate( customers.getCreateDate() );
        staffResponse.setActive( customers.isActive() );
        staffResponse.setStaffId( customers.getStaffId() );
        staffResponse.setUsername( customers.getUsername() );

        return staffResponse;
    }

    protected Store staffDtoToStore(StaffDto staffDto) {
        if ( staffDto == null ) {
            return null;
        }

        Store store = new Store();

        if ( staffDto.getStoreId() != null ) {
            store.setStoreId( staffDto.getStoreId() );
        }

        return store;
    }

    protected Country staffDtoToCountry(StaffDto staffDto) {
        if ( staffDto == null ) {
            return null;
        }

        Country country = new Country();

        country.setCountry( staffDto.getCountry() );

        return country;
    }

    protected City staffDtoToCity(StaffDto staffDto) {
        if ( staffDto == null ) {
            return null;
        }

        City city = new City();

        city.setCountry( staffDtoToCountry( staffDto ) );
        city.setCity( staffDto.getCity() );

        return city;
    }

    protected Address staffDtoToAddress(StaffDto staffDto) {
        if ( staffDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setCity( staffDtoToCity( staffDto ) );
        address.setAddress( staffDto.getAddress() );
        address.setDistrict( staffDto.getDistrict() );
        address.setPostalCode( staffDto.getPostalCode() );
        address.setPhone( staffDto.getPhone() );

        return address;
    }

    protected Payment paymentDtoToPayment(PaymentDto paymentDto) {
        if ( paymentDto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setPaymentId( paymentDto.getPaymentId() );
        payment.setAmount( paymentDto.getAmount() );
        payment.setPaymentDate( paymentDto.getPaymentDate() );

        return payment;
    }

    protected Set<Payment> paymentDtoSetToPaymentSet(Set<PaymentDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Payment> set1 = new LinkedHashSet<Payment>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PaymentDto paymentDto : set ) {
            set1.add( paymentDtoToPayment( paymentDto ) );
        }

        return set1;
    }

    protected Set<Rental> rentDtoSetToRentalSet(Set<RentDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Rental> set1 = new LinkedHashSet<Rental>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RentDto rentDto : set ) {
            set1.add( rentalMapper.toEntity( rentDto ) );
        }

        return set1;
    }

    private Integer staffStoreStoreId(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Store store = staff.getStore();
        if ( store == null ) {
            return null;
        }
        int storeId = store.getStoreId();
        return storeId;
    }

    private String staffAddressCityCity(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Address address = staff.getAddress();
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

    private String staffAddressCityCountryCountry(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Address address = staff.getAddress();
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

    private String staffAddressAddress(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Address address = staff.getAddress();
        if ( address == null ) {
            return null;
        }
        String address1 = address.getAddress();
        if ( address1 == null ) {
            return null;
        }
        return address1;
    }

    private String staffAddressDistrict(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Address address = staff.getAddress();
        if ( address == null ) {
            return null;
        }
        String district = address.getDistrict();
        if ( district == null ) {
            return null;
        }
        return district;
    }

    private String staffAddressPostalCode(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Address address = staff.getAddress();
        if ( address == null ) {
            return null;
        }
        String postalCode = address.getPostalCode();
        if ( postalCode == null ) {
            return null;
        }
        return postalCode;
    }

    private String staffAddressPhone(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Address address = staff.getAddress();
        if ( address == null ) {
            return null;
        }
        String phone = address.getPhone();
        if ( phone == null ) {
            return null;
        }
        return phone;
    }

    protected PaymentDto paymentToPaymentDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setPaymentId( payment.getPaymentId() );
        paymentDto.setAmount( payment.getAmount() );
        paymentDto.setPaymentDate( payment.getPaymentDate() );

        return paymentDto;
    }

    protected Set<PaymentDto> paymentSetToPaymentDtoSet(Set<Payment> set) {
        if ( set == null ) {
            return null;
        }

        Set<PaymentDto> set1 = new LinkedHashSet<PaymentDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Payment payment : set ) {
            set1.add( paymentToPaymentDto( payment ) );
        }

        return set1;
    }

    protected Set<RentDto> rentalSetToRentDtoSet(Set<Rental> set) {
        if ( set == null ) {
            return null;
        }

        Set<RentDto> set1 = new LinkedHashSet<RentDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Rental rental : set ) {
            set1.add( rentalMapper.toDto( rental ) );
        }

        return set1;
    }

    protected void staffDtoToStore1(StaffDto staffDto, Store mappingTarget) {
        if ( staffDto == null ) {
            return;
        }

        if ( staffDto.getStoreId() != null ) {
            mappingTarget.setStoreId( staffDto.getStoreId() );
        }
    }

    protected void staffDtoToCountry1(StaffDto staffDto, Country mappingTarget) {
        if ( staffDto == null ) {
            return;
        }

        if ( staffDto.getCountry() != null ) {
            mappingTarget.setCountry( staffDto.getCountry() );
        }
    }

    protected void staffDtoToCity1(StaffDto staffDto, City mappingTarget) {
        if ( staffDto == null ) {
            return;
        }

        if ( mappingTarget.getCountry() == null ) {
            mappingTarget.setCountry( new Country() );
        }
        staffDtoToCountry1( staffDto, mappingTarget.getCountry() );
        if ( staffDto.getCity() != null ) {
            mappingTarget.setCity( staffDto.getCity() );
        }
    }

    protected void staffDtoToAddress1(StaffDto staffDto, Address mappingTarget) {
        if ( staffDto == null ) {
            return;
        }

        if ( mappingTarget.getCity() == null ) {
            mappingTarget.setCity( new City() );
        }
        staffDtoToCity1( staffDto, mappingTarget.getCity() );
        if ( staffDto.getAddress() != null ) {
            mappingTarget.setAddress( staffDto.getAddress() );
        }
        if ( staffDto.getDistrict() != null ) {
            mappingTarget.setDistrict( staffDto.getDistrict() );
        }
        if ( staffDto.getPostalCode() != null ) {
            mappingTarget.setPostalCode( staffDto.getPostalCode() );
        }
        if ( staffDto.getPhone() != null ) {
            mappingTarget.setPhone( staffDto.getPhone() );
        }
    }
}
