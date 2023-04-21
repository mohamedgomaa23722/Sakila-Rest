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
public class StaffResponse extends HumanResponse{
    private int staffId;
    private String username;
}
