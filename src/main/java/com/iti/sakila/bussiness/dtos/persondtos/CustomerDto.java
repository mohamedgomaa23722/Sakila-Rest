package com.iti.sakila.bussiness.dtos.persondtos;

import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessOrder;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class CustomerDto extends HumanDto implements Serializable {
    private Short customerId;
}