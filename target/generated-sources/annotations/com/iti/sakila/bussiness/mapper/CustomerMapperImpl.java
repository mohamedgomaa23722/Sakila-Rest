package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.dtos.customerdtos.CustomerResponse;
import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.bussiness.dtos.persondtos.CustomerDto;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import com.iti.sakila.persistance.entity.Address;
import com.iti.sakila.persistance.entity.City;
import com.iti.sakila.persistance.entity.Country;
import com.iti.sakila.persistance.entity.Customer;
import com.iti.sakila.persistance.entity.Payment;
import com.iti.sakila.persistance.entity.Rental;
import com.iti.sakila.persistance.entity.Store;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T03:51:07+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    private final RentalMapper rentalMapper = RentalMapper.INSTANCE;

    @Override
    public List<CustomerDto> toDtoList(List<Customer> list) {
        if ( list == null ) {
            return null;
        }

        List<CustomerDto> list1 = new ArrayList<CustomerDto>( list.size() );
        for ( Customer customer : list ) {
            list1.add( toDto( customer ) );
        }

        return list1;
    }

    @Override
    public Customer toEntity(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setStore( customerDtoToStore( customerDto ) );
        customer.setAddress( customerDtoToAddress( customerDto ) );
        customer.setCustomerId( customerDto.getCustomerId() );
        customer.setFirstName( customerDto.getFirstName() );
        customer.setLastName( customerDto.getLastName() );
        customer.setEmail( customerDto.getEmail() );
        customer.setActive( customerDto.isActive() );
        customer.setCreateDate( customerDto.getCreateDate() );
        customer.setPayments( paymentDtoSetToPaymentSet( customerDto.getPayments() ) );
        customer.setRentals( rentDtoSetToRentalSet( customerDto.getRentals() ) );

        linkPayments( customer );
        linkRentals( customer );

        return customer;
    }

    @Override
    public CustomerDto toDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        Integer storeId = customerStoreStoreId( customer );
        if ( storeId != null ) {
            customerDto.setStoreId( storeId.byteValue() );
        }
        customerDto.setCity( customerAddressCityCity( customer ) );
        customerDto.setCountry( customerAddressCityCountryCountry( customer ) );
        customerDto.setAddress( customerAddressAddress( customer ) );
        customerDto.setDistrict( customerAddressDistrict( customer ) );
        customerDto.setPostalCode( customerAddressPostalCode( customer ) );
        customerDto.setPhone( customerAddressPhone( customer ) );
        customerDto.setFirstName( customer.getFirstName() );
        customerDto.setLastName( customer.getLastName() );
        customerDto.setEmail( customer.getEmail() );
        customerDto.setCreateDate( customer.getCreateDate() );
        customerDto.setActive( customer.isActive() );
        customerDto.setPayments( paymentSetToPaymentDtoSet( customer.getPayments() ) );
        customerDto.setRentals( rentalSetToRentDtoSet( customer.getRentals() ) );
        customerDto.setCustomerId( customer.getCustomerId() );

        return customerDto;
    }

    @Override
    public CustomerResponse toResponse(CustomerDto customers) {
        if ( customers == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setPaymentsAmount( convertToString( customers.getPayments() ) );
        customerResponse.setRentAmount( convertToRentalAmount( customers.getRentals() ) );
        customerResponse.setFirstName( customers.getFirstName() );
        customerResponse.setLastName( customers.getLastName() );
        customerResponse.setStoreId( customers.getStoreId() );
        customerResponse.setEmail( customers.getEmail() );
        customerResponse.setPhone( customers.getPhone() );
        customerResponse.setCountry( customers.getCountry() );
        customerResponse.setCity( customers.getCity() );
        customerResponse.setAddress( customers.getAddress() );
        customerResponse.setDistrict( customers.getDistrict() );
        customerResponse.setPostalCode( customers.getPostalCode() );
        customerResponse.setCreateDate( customers.getCreateDate() );
        customerResponse.setActive( customers.isActive() );
        customerResponse.setCustomerId( customers.getCustomerId() );

        return customerResponse;
    }

    @Override
    public List<CustomerResponse> toResponseList(List<CustomerDto> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerResponse> list = new ArrayList<CustomerResponse>( customers.size() );
        for ( CustomerDto customerDto : customers ) {
            list.add( toResponse( customerDto ) );
        }

        return list;
    }

    @Override
    public Customer partialUpdate(CustomerDto customerDto, Customer customer) {
        if ( customerDto == null ) {
            return customer;
        }

        if ( customer.getStore() == null ) {
            customer.setStore( new Store() );
        }
        customerDtoToStore1( customerDto, customer.getStore() );
        if ( customer.getAddress() == null ) {
            customer.setAddress( new Address() );
        }
        customerDtoToAddress1( customerDto, customer.getAddress() );
        if ( customerDto.getCustomerId() != null ) {
            customer.setCustomerId( customerDto.getCustomerId() );
        }
        if ( customerDto.getFirstName() != null ) {
            customer.setFirstName( customerDto.getFirstName() );
        }
        if ( customerDto.getLastName() != null ) {
            customer.setLastName( customerDto.getLastName() );
        }
        if ( customerDto.getEmail() != null ) {
            customer.setEmail( customerDto.getEmail() );
        }
        customer.setActive( customerDto.isActive() );
        if ( customerDto.getCreateDate() != null ) {
            customer.setCreateDate( customerDto.getCreateDate() );
        }
        if ( customer.getPayments() != null ) {
            Set<Payment> set = paymentDtoSetToPaymentSet( customerDto.getPayments() );
            if ( set != null ) {
                customer.getPayments().clear();
                customer.getPayments().addAll( set );
            }
        }
        else {
            Set<Payment> set = paymentDtoSetToPaymentSet( customerDto.getPayments() );
            if ( set != null ) {
                customer.setPayments( set );
            }
        }
        if ( customer.getRentals() != null ) {
            Set<Rental> set1 = rentDtoSetToRentalSet( customerDto.getRentals() );
            if ( set1 != null ) {
                customer.getRentals().clear();
                customer.getRentals().addAll( set1 );
            }
        }
        else {
            Set<Rental> set1 = rentDtoSetToRentalSet( customerDto.getRentals() );
            if ( set1 != null ) {
                customer.setRentals( set1 );
            }
        }

        linkPayments( customer );
        linkRentals( customer );

        return customer;
    }

    protected Store customerDtoToStore(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Store store = new Store();

        if ( customerDto.getStoreId() != null ) {
            store.setStoreId( customerDto.getStoreId() );
        }

        return store;
    }

    protected Country customerDtoToCountry(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Country country = new Country();

        country.setCountry( customerDto.getCountry() );

        return country;
    }

    protected City customerDtoToCity(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        City city = new City();

        city.setCountry( customerDtoToCountry( customerDto ) );
        city.setCity( customerDto.getCity() );

        return city;
    }

    protected Address customerDtoToAddress(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setCity( customerDtoToCity( customerDto ) );
        address.setAddress( customerDto.getAddress() );
        address.setDistrict( customerDto.getDistrict() );
        address.setPostalCode( customerDto.getPostalCode() );
        address.setPhone( customerDto.getPhone() );

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

    private Integer customerStoreStoreId(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Store store = customer.getStore();
        if ( store == null ) {
            return null;
        }
        int storeId = store.getStoreId();
        return storeId;
    }

    private String customerAddressCityCity(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Address address = customer.getAddress();
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

    private String customerAddressCityCountryCountry(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Address address = customer.getAddress();
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

    private String customerAddressAddress(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Address address = customer.getAddress();
        if ( address == null ) {
            return null;
        }
        String address1 = address.getAddress();
        if ( address1 == null ) {
            return null;
        }
        return address1;
    }

    private String customerAddressDistrict(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Address address = customer.getAddress();
        if ( address == null ) {
            return null;
        }
        String district = address.getDistrict();
        if ( district == null ) {
            return null;
        }
        return district;
    }

    private String customerAddressPostalCode(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Address address = customer.getAddress();
        if ( address == null ) {
            return null;
        }
        String postalCode = address.getPostalCode();
        if ( postalCode == null ) {
            return null;
        }
        return postalCode;
    }

    private String customerAddressPhone(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Address address = customer.getAddress();
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

    protected void customerDtoToStore1(CustomerDto customerDto, Store mappingTarget) {
        if ( customerDto == null ) {
            return;
        }

        if ( customerDto.getStoreId() != null ) {
            mappingTarget.setStoreId( customerDto.getStoreId() );
        }
    }

    protected void customerDtoToCountry1(CustomerDto customerDto, Country mappingTarget) {
        if ( customerDto == null ) {
            return;
        }

        if ( customerDto.getCountry() != null ) {
            mappingTarget.setCountry( customerDto.getCountry() );
        }
    }

    protected void customerDtoToCity1(CustomerDto customerDto, City mappingTarget) {
        if ( customerDto == null ) {
            return;
        }

        if ( mappingTarget.getCountry() == null ) {
            mappingTarget.setCountry( new Country() );
        }
        customerDtoToCountry1( customerDto, mappingTarget.getCountry() );
        if ( customerDto.getCity() != null ) {
            mappingTarget.setCity( customerDto.getCity() );
        }
    }

    protected void customerDtoToAddress1(CustomerDto customerDto, Address mappingTarget) {
        if ( customerDto == null ) {
            return;
        }

        if ( mappingTarget.getCity() == null ) {
            mappingTarget.setCity( new City() );
        }
        customerDtoToCity1( customerDto, mappingTarget.getCity() );
        if ( customerDto.getAddress() != null ) {
            mappingTarget.setAddress( customerDto.getAddress() );
        }
        if ( customerDto.getDistrict() != null ) {
            mappingTarget.setDistrict( customerDto.getDistrict() );
        }
        if ( customerDto.getPostalCode() != null ) {
            mappingTarget.setPostalCode( customerDto.getPostalCode() );
        }
        if ( customerDto.getPhone() != null ) {
            mappingTarget.setPhone( customerDto.getPhone() );
        }
    }
}
