package com.iti.sakila.bussiness.service;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.persondtos.CustomerDto;
import com.iti.sakila.bussiness.exceptions.NotExistException;
import com.iti.sakila.bussiness.mapper.CustomerMapper;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.entity.Address;
import com.iti.sakila.persistance.entity.City;
import com.iti.sakila.persistance.entity.Country;
import com.iti.sakila.persistance.entity.Customer;
import com.iti.sakila.persistance.repository.BaseRepository;

public class CustomerService extends BaseService<Customer, CustomerDto> {
    private final BaseRepository<Country> countryBaseRepository = new BaseRepository<>(Country.class);
    private final BaseRepository<City> cityBaseRepository = new BaseRepository<>(City.class);

    public CustomerService() {
        super(Customer.class, CustomerMapper.INSTANCE);
    }

    @Override
    public Message insert(CustomerDto customerDto) {
        Customer customer = super.baseMapper.toEntity(customerDto);
        return Database.doInTransaction(entityManager -> {
            //We need to check availability of country and city
            System.out.println(customer);
            Address address = new Address();

            String city = customerDto.getCity();
            String country = customerDto.getCountry();

            City cityObj = cityBaseRepository.isExist(city, "city", entityManager);
            Country countryObj = countryBaseRepository.isExist(country, "country", entityManager);

            if (cityObj != null)
                customer.getAddress().setCity(cityObj);
            else
                throw new NotExistException("There are no city called : " + customerDto.getCity());
            // We need to check if this country contain this country or not
            if (countryObj != null) {
                if (cityObj.getCountry().getCountryId().equals(countryObj.getCountryId()))
                    customer.getAddress().getCity().setCountry(countryObj);
                else
                    throw new NotExistException("This city not belongs to this country");
            } else
                throw new NotExistException("There are no country called : " + customerDto.getCountry());


            System.out.println("City : " + customer.getAddress().getCity().getCity());
            System.out.println("Country : " + customer.getAddress().getCity().getCountry().getCountry());

            Customer object = super.repository.insert(customer, entityManager);

            return super.generateMessage(CustomerMapper.INSTANCE.toDto(object));
        });
    }
}
