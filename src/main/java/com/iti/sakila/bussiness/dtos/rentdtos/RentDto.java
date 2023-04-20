package com.iti.sakila.bussiness.dtos.rentdtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType(propOrder = {"rentalId","inventoryId","staffId","filmName","customerId","customerName","rentalDate","returnDate"})
public class RentDto {
    @NotNull(message = "please enter rental id")
    @Positive(message = "Please Enter positive id")
    private Integer rentalId;
    private Date rentalDate;
    private Date returnDate;
    private String customerName;
    private Short customerId;
    private String filmName;
    private int inventoryId;

    private int staffId;

    @Override
    public String toString() {
        return "RentalCustomerDto{" +
                "rentalId=" + rentalId +
                ", rentalDate=" + rentalDate.getTime() +
                ", returnDate=" + returnDate.getTime() +
                ", customerName='" + customerName + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
