package com.iti.sakila.bussiness.dtos.persondtos;

import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HumanDto {
    @NotNull(message = "please enter first name")
    @Size(min = 4, max = 30, message = "please enter firstName size between 4 to 30 characters")
    private String firstName;
    @NotNull(message = "please enter last name")
    @Size(min = 4, max = 30, message = "please enter lastName size between 4 to 30 characters")
    private String lastName;
    @NotNull(message = "please enter last name")
    @Positive(message = "Please Enter positive store id")
    private Byte storeId;
    @NotNull(message = "Please Enter Email")
    @Email(message = "Please Enter Email Format example: xyz@gmail.com")
    private String email;
    @NotNull(message = "please enter phone")
    @Size(min = 8, max = 25, message = "please enter phone size between 8 to 25 characters")
    private String phone;
    @NotNull(message = "please enter country")
    @Size(min = 3, max = 20, message = "please enter country size between 3 to 20 characters")
    private String country;
    @NotNull(message = "please enter city")
    @Size(min = 3, max = 20, message = "please enter city size between 3 to 20 characters")
    private String city;
    @NotNull(message = "please enter address")
    @Size(min = 10, max = 30, message = "please enter address size between 10 to 30 characters")
    private String address;
    @NotNull(message = "please enter district")
    @Size(min = 3, max = 20, message = "please enter district size between 10 to 20 characters")
    private String district;
    @NotNull(message = "please enter postalCode")
    @Size(min = 3, max = 8, message = "please enter postalCode size between 3 to 8 characters")
    private String postalCode;
    private Timestamp createDate;
    private boolean active;
    private Set<PaymentDto> payments = new HashSet<>(0);
    private Set<RentDto> rentals = new HashSet<>(0);
}
