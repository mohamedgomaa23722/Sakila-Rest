package com.iti.sakila.api.dtos.customerdtos;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
public class StaffResponse {
    private int staffId;
    private String username;
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
