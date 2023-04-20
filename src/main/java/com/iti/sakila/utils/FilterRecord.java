package com.iti.sakila.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class FilterRecord {
    private  int page = 1;
    private  int categoryId = 0;
    private  BigDecimal price = new BigDecimal(0);
    private  BigDecimal rate = new BigDecimal(0);
    private  String name = "";
}
