package com.iti.sakila.api.rest;

import com.iti.sakila.api.dtos.customerdtos.CustomerResponse;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.persondtos.CustomerDto;
import com.iti.sakila.bussiness.mapper.CustomerMapper;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.persistance.entity.Store;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

//@Path("v1/stores")
public class StoreResource {
//    BaseService<Store>
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<CustomerResponse> getCustomers(@DefaultValue("1") @QueryParam("page") int page) {
//        List<CustomerDto> customers = customerService.getAll(page);
//        return CustomerMapper.INSTANCE.toResponseList(customers);
//    }
//
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Message insertCustomer(CustomerDto customerDto) {
//        return customerService.insert(customerDto);
//    }
//
//    @DELETE
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Message deleteCustomer(@PathParam("id") int id) {
//        return customerService.delete(id);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Message updateCustomer(CustomerDto customerDto,@PathParam("id") int id) {
//        return customerService.update(customerDto, id);
//    }
}
