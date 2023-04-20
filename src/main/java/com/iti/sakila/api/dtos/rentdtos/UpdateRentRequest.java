package com.iti.sakila.api.dtos.rentdtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRentRequest {
    private  int rentalId;
    private Short customerId;
    private int inventoryId;
    private int staffId;
    private  Date returnDate;
    private  Date rentalDate;
}
