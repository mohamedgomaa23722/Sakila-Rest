package com.iti.sakila.api.dtos.customerdtos;

import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CustomerRentalResponse {
    private int customerId;
    private String customerName;
    private Set<RentDto> rentals = new HashSet<>(0);
}
