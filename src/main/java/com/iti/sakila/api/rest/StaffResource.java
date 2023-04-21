package com.iti.sakila.api.rest;

import com.iti.sakila.api.dtos.customerdtos.CustomerResponse;
import com.iti.sakila.api.dtos.customerdtos.StaffResponse;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.bussiness.dtos.persondtos.CustomerDto;
import com.iti.sakila.bussiness.dtos.persondtos.StaffDto;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import com.iti.sakila.bussiness.mapper.StaffMapper;
import com.iti.sakila.bussiness.service.PaymentService;
import com.iti.sakila.bussiness.service.RentService;
import com.iti.sakila.bussiness.service.StaffService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("v1/staffs")
public class StaffResource {

    private final StaffService staffService = new StaffService();
    ;
    private final PaymentService paymentService = new PaymentService();
    private final RentService rentService = new RentService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffResponse> getStaffs(@DefaultValue("1") @QueryParam("page") int page) {
        List<StaffDto> staffs = staffService.getAll(page);
        return StaffMapper.INSTANCE.toResponseList(staffs);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Message insertStaff(StaffDto staffDto) {
        return staffService.insert(staffDto);
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateStaff(StaffDto staffDto, @PathParam("id") int id) {
        StaffDto staff = staffService.findById(id);
        return staffService.update(staffDto, id);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message deleteStaff(@PathParam("id") int id) {
        return staffService.delete(id);
    }

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffResponse> findStaffByName(@QueryParam("name") String name,
                                               @DefaultValue("1") @QueryParam("page") int page) {
        return StaffMapper.INSTANCE.toResponseList(staffService.findByName(name, "firstName", page));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StaffResponse findStaffById(@PathParam("id") int id) {
        StaffDto staff = staffService.findById(id);
        return StaffMapper.INSTANCE.toResponse(staff);
    }

    @GET
    @Path("{id}/payments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PaymentDto> findStaffPayment(@PathParam("id") int staffId, @DefaultValue("1") @QueryParam("page") int page) {
        return paymentService.findTransactionsForStaff(staffId, page);
    }

    @GET
    @Path("{id}/rentals")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RentDto> findStaffRentals(@PathParam("id") int staffId, @DefaultValue("1") @QueryParam("page") int page) {
        List<RentDto> rentals = rentService.findTransactionsForStaff(staffId, page);
        System.out.println(rentals);
        return rentals;
    }

}
