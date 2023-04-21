package com.iti.sakila.api.dtos.customerdtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HumanResponse {
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
}
