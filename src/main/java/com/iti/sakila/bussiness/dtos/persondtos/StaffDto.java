package com.iti.sakila.bussiness.dtos.persondtos;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class StaffDto extends HumanDto implements Serializable {
    private int staffId;
    private String username;
}
