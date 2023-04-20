package com.iti.sakila.bussiness.service;

import com.iti.sakila.api.dtos.rentdtos.InsertRentalRequest;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.MessageBuilder;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import com.iti.sakila.bussiness.mapper.RentalMapper;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.entity.*;
import com.iti.sakila.persistance.repository.BaseRepository;
import com.iti.sakila.persistance.repository.PaymentRepository;
import com.iti.sakila.persistance.repository.RentalRepository;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RentService extends BaseTransactionService<Rental, RentDto> {

    private final RentalRepository rentalRepository = new RentalRepository();
    private final PaymentRepository paymentRepository = new PaymentRepository();

    public RentService() {
        super(Rental.class, RentalMapper.INSTANCE);
    }

    public List<RentDto> findRentalByInventory(int inventoryId) {
        return Database.doInTransaction(entityManager -> RentalMapper.INSTANCE.toDtoList(rentalRepository.findRentalByInventory(inventoryId, entityManager)));
    }

    /**
     * 1 - check film length before any thing (film id) done
     * 2- insert to inventory record (film id , store id)
     * 3- insert to Rental (inventory id, customer id, staff id)
     * 4- insert payment method (customer id, staff id, renatal id)
     * 5- return message
     * commons : (film id, customer id, staff id, store id)
     **/
    public Message insertRental(InsertRentalRequest rentalDto) {
        //Get film by id
        BaseRepository<Film> filmBaseRepository = new BaseRepository<>(Film.class);
        BaseRepository<Customer> customerBaseRepository = new BaseRepository<>(Customer.class);
        BaseRepository<Staff> staffBaseRepository = new BaseRepository<>(Staff.class);
        BaseRepository<Inventory> inventoryBaseRepository = new BaseRepository<>(Inventory.class);

        return Database.doInTransaction(entityManager -> {
            //Create Rental object
            Rental rental = new Rental();

            Film film = filmBaseRepository.findById(rentalDto.getFilmId(), entityManager);
            //check if length of film is bigger than zero
            if (film.getLength() > 0) {
                //then set film into inventory object
                Inventory inventory = new Inventory();
                inventory.setFilm(film);

                // now we need to get customer
                Customer customer = customerBaseRepository.findById(rentalDto.getCustomerId(), entityManager);

                // set store to inventory
                inventory.setStore(customer.getStore());
                inventory = inventoryBaseRepository.insert(inventory,entityManager);
                //set inventory to rental process
                rental.setInventory(inventory);

                // set customer to rental
                rental.setCustomer(customer);

                //set staff to rental
                Staff staff = staffBaseRepository.findById(rentalDto.getStaffId(), entityManager);
                rental.setStaff(staff);

                //set return date current date + rental duration of film
                rental.setReturnDate(getFilmReturnDate(film.getRentalDuration()));

                //insert rental object
                rental = baseTransaction.insert(rental, entityManager);
                System.out.println(rental);

                //Then insert Payment
                Payment payment = new Payment(staff, customer, rental, film.getReplacementCost(), new Date(), new Date());
                paymentRepository.insert(payment, entityManager);

                return new MessageBuilder()
                        .setSuccessfullyMessage("Successfully inserted")
                        .setSuccessfullyMessageDesc("inserted rental operation with id = " + rental.getRentalId() + " for film = " + film.getFilmId())
                        .setSuccessfully(true)
                        .build();
            } else {
                throw new RuntimeException("There are no more item on the stock for that film");
            }
        });
    }

    public Timestamp getFilmReturnDate(int rentalDuration) {
        Timestamp returnDate = new Timestamp(new Date().getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(returnDate);
        cal.add(Calendar.DAY_OF_WEEK, rentalDuration);
        returnDate.setTime(cal.getTime().getTime());
        return returnDate;
    }
}
