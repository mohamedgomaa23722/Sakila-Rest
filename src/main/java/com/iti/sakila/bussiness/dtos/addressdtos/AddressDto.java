package com.iti.sakila.bussiness.dtos.addressdtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class AddressDto implements Serializable {
    @NotNull(message = "please enter address id")
    @Positive(message = "Please Enter positive address id")
    private Short addressId;
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
    @NotNull(message = "please enter phone")
    @Size(min = 8, max = 25, message = "please enter phone size between 8 to 25 characters")
    private String phone;
}