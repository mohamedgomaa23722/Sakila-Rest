package com.iti.sakila.bussiness.service;

import com.iti.sakila.bussiness.dtos.Message;

import com.iti.sakila.bussiness.dtos.persondtos.StaffDto;
import com.iti.sakila.bussiness.mapper.StaffMapper;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.entity.City;
import com.iti.sakila.persistance.entity.Country;
import com.iti.sakila.persistance.entity.Staff;
import com.iti.sakila.persistance.repository.BaseRepository;

public class StaffService extends BaseService<Staff, StaffDto> {
    private final BaseRepository<Country> countryBaseRepository = new BaseRepository<>(Country.class);
    private final BaseRepository<City> cityBaseRepository = new BaseRepository<>(City.class);

    public StaffService() {
        super(Staff.class, StaffMapper.INSTANCE);
    }

    /**
     * To update  Person We need to take follows in consideration :
     * 1- update staff city
     * 2- update staff country
     * 3- update staff address this includes city and country
     * 4- update staff name and other main poperty for staff
     * @param dto
     * @param id
     * @return
     */
//    @Override
//    public Message update(StaffDto dto, int id) {
//        Database.doInTransaction(entityManager -> {
//            //Find staff before update
//            Staff staff = super.repository.findById(id, entityManager);
//
//            //Check address
//            if (dto.getCity() != null && !dto.getCity().equals(staff.getAddress().getCity().getCity())){
//
//            }
//
//        });
//
//        return super.update(dto, id);
//    }

    @Override
    public Message insert(StaffDto customerDto) {
        Staff customer = super.baseMapper.toEntity(customerDto);
        return Database.doInTransaction(entityManager -> {
            //We need to check availability of country and city
            String city = customerDto.getCity();
            String country = customerDto.getCountry();

            City cityObj = cityBaseRepository.isExist(city, "city", entityManager);
            Country countryObj = countryBaseRepository.isExist(country, "country", entityManager);

            if (cityObj != null)
                customer.getAddress().setCity(cityObj);

            if (countryObj != null)
                customer.getAddress().getCity().setCountry(countryObj);

            System.out.println("City : " + customer.getAddress().getCity().getCity());
            System.out.println("Country : " + customer.getAddress().getCity().getCountry().getCountry());

            Staff object = super.repository.insert(customer, entityManager);

            return super.generateMessage(StaffMapper.INSTANCE.toDto(object));
        });
    }
}