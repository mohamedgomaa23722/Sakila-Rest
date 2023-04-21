package com.iti.sakila.api.rest;

import com.iti.sakila.api.dtos.rentdtos.InsertRentalRequest;
import com.iti.sakila.api.dtos.rentdtos.UpdateRentRequest;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import com.iti.sakila.bussiness.mapper.RentalMapper;
import com.iti.sakila.bussiness.service.PaymentService;
import com.iti.sakila.bussiness.service.RentService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Path("v1/rentals")

public class RentalResource {
    private final RentService rentService = new RentService();

    private final PaymentService paymentService = new PaymentService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RentDto> getRentals(@DefaultValue("1") @QueryParam("page") int page) {
        return rentService.getAll(page);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RentDto findRentalById(@PathParam("id") int id) {
        return rentService.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Message insertRental(InsertRentalRequest insertRentalRequest) {
        return rentService.insertRental(insertRentalRequest);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateRental(UpdateRentRequest updateRentRequest) {
        RentDto rentDto = RentalMapper.INSTANCE.fromRentalRequest(updateRentRequest);
        return rentService.update(rentDto, rentDto.getRentalId());
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message delete(@PathParam("id") int id) {
        return rentService.delete(id);
    }

//    @WebMethod
//    public List<RentDto> findStaffRentals(@WebParam(name = "staffId") int staffId, @WebParam(name = "page") int page) {
//        return rentService.findTransactionsForStaff(staffId, page);
//    }

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RentDto> findRentalsByRentalDate(@QueryParam("from") String from,
                                                 @QueryParam("to") String to,
                                                 @QueryParam("page") int page) throws ParseException {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-mm-dd");
        Date fromDate = simpleDate.parse(from);
        Date toDate = simpleDate.parse(to);
        return rentService.findTransactionByDate(fromDate, toDate, page);
    }

    @GET
    @Path("{rentalId}/payments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PaymentDto> findPaymentByRental(@PathParam("rentalId") int rentalId, @DefaultValue("1") @QueryParam("page") int page) {
        return paymentService.findByRental(rentalId, page);
    }
}
