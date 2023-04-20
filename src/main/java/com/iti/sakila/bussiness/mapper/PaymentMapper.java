package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.persistance.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "default")
public interface PaymentMapper extends BaseMapper<Payment, PaymentDto> {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
}