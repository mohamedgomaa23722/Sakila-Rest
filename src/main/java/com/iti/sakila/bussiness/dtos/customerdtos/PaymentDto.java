package com.iti.sakila.bussiness.dtos.customerdtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class PaymentDto implements Serializable {
    @NotNull(message = "please enter payment id")
    @Positive(message = "Please Enter positive id")
    @Min(value = 1, message = "payment id must be bigger than 0")
    private Short paymentId;
    @NotNull(message = "please enter amount")
    @Positive(message = "Please Enter positive amount")
    private BigDecimal amount;
    private Date paymentDate;
}