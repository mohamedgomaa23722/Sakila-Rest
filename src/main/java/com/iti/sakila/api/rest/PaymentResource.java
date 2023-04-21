package com.iti.sakila.api.rest;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.bussiness.service.PaymentService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.mapstruct.ap.shaded.freemarker.template.SimpleDate;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("v1/payments")
public class PaymentResource {
    private final PaymentService paymentService = new PaymentService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PaymentDto> getPayments(@DefaultValue("1") @QueryParam("page") int page) {
        return paymentService.getAll(page);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PaymentDto getPayment(@PathParam("id") int id) {
        return paymentService.findById(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Message updatePayment(PaymentDto payment) {
        return paymentService.update(payment, payment.getPaymentId());
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message deletePayment(@PathParam("id") int id) {
        return paymentService.delete(id);
    }

    @GET
    @Path("filterByAmount")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PaymentDto> findPaymentByAmount(@QueryParam("amount") String amount,
                                                @DefaultValue("1") @QueryParam("page") int page) {
        List<PaymentDto> payments = paymentService.findByAmount(new BigDecimal(amount), page);
        System.out.println("findPaymentByAmount : " + amount);
        System.out.println("Payments : " + payments);
        return payments;
    }



    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PaymentDto> findPaymentByDate(@QueryParam("from") String from,
                                              @QueryParam("to") String to,
                                              @QueryParam("page") int page) throws ParseException {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-mm-dd");
        Date fromDate = simpleDate.parse(from);
        Date toDate = simpleDate.parse(to);
        return paymentService.findTransactionByDate(fromDate, toDate, page);
    }

//    @GET
//    @Path("filterByRentals")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<PaymentDto> findPaymentByStaff(@QueryParam("staffId") int id, @QueryParam("page") int page) {
//        return paymentService.findTransactionsForStaff(id, page);
//    }
}
