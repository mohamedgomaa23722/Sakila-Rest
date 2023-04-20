package com.iti.sakila.api.rest.impl;

import com.iti.sakila.api.dtos.customerdtos.CustomerResponse;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.bussiness.dtos.persondtos.CustomerDto;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import com.iti.sakila.bussiness.mapper.CustomerMapper;
import com.iti.sakila.bussiness.service.CustomerService;
import com.iti.sakila.bussiness.service.PaymentService;
import com.iti.sakila.bussiness.service.RentService;
import com.iti.sakila.persistance.entity.Customer;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("v1/customers")
public class CustomerResource {
    private final CustomerService customerService = new CustomerService();;
    private final PaymentService paymentService = new PaymentService();

    private final RentService rentService = new RentService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerResponse> getCustomers(@DefaultValue("1") @QueryParam("page") int page) {
        List<CustomerDto> customers = customerService.getAll(page);
        return CustomerMapper.INSTANCE.toResponseList(customers);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Message insertCustomer(CustomerDto customerDto) {
        return customerService.insert(customerDto);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message deleteCustomer(@PathParam("id") int id) {
        return customerService.delete(id);
    }

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerResponse> findCustomerByName(@QueryParam("name") String name,
                                                @DefaultValue("1") @QueryParam("page") int page) {
        return CustomerMapper.INSTANCE.toResponseList(customerService.findByName(name,"firstName", page));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerResponse findCustomerById(@PathParam("id") int id) {
        CustomerDto customerDto = customerService.findById(id);
        return CustomerMapper.INSTANCE.toResponse(customerDto);
    }

    @GET
    @Path("{id}/payments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PaymentDto> findPaymentByCustomer(@PathParam("id") int customerId, @DefaultValue("1") @QueryParam("page") int page) {
        return paymentService.findTransactionsForCustomer(customerId, page);
    }

    @GET
    @Path("{id}/rentals")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RentDto> findCustomerRentals(@PathParam("id") int customerId, @DefaultValue("1") @QueryParam("page") int page) {
        List<RentDto> rentals = rentService.findTransactionsForCustomer(customerId, page);
        System.out.println(rentals);
        return rentals;
    }
}
