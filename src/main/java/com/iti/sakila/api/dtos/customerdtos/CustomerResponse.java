package com.iti.sakila.api.dtos.customerdtos;

import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse extends HumanResponse{
    private Short customerId;
}
