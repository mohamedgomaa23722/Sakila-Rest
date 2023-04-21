package com.iti.sakila.bussiness.dtos.persondtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public final class CustomerDto extends HumanDto implements Serializable {
    private Short customerId;
}