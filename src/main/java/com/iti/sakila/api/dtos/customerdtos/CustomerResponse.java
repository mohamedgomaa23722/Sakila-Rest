package com.iti.sakila.api.dtos.customerdtos;

import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Data
@ToString
public class CustomerResponse {
    private Short customerId;
    private String firstName;
    private String lastName;
    private Byte storeId;
    private String email;
    private String phone;
    private String country;
    private String city;
    private String address;
    private String district;
    private String postalCode;
    private Timestamp createDate;
    private boolean active;
    private String paymentsAmount;
    private int rentAmount;
    public void setRentAmount(int rentAmount) {
        this.rentAmount = rentAmount;
    }
}
