package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.persistance.entity.Payment;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T03:51:06+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public List<PaymentDto> toDtoList(List<Payment> list) {
        if ( list == null ) {
            return null;
        }

        List<PaymentDto> list1 = new ArrayList<PaymentDto>( list.size() );
        for ( Payment payment : list ) {
            list1.add( toDto( payment ) );
        }

        return list1;
    }

    @Override
    public Payment toEntity(PaymentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setPaymentId( dto.getPaymentId() );
        payment.setAmount( dto.getAmount() );
        payment.setPaymentDate( dto.getPaymentDate() );

        return payment;
    }

    @Override
    public PaymentDto toDto(Payment entity) {
        if ( entity == null ) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setPaymentId( entity.getPaymentId() );
        paymentDto.setAmount( entity.getAmount() );
        paymentDto.setPaymentDate( entity.getPaymentDate() );

        return paymentDto;
    }

    @Override
    public Payment partialUpdate(PaymentDto dto, Payment entity) {
        if ( dto == null ) {
            return entity;
        }

        if ( dto.getPaymentId() != null ) {
            entity.setPaymentId( dto.getPaymentId() );
        }
        if ( dto.getAmount() != null ) {
            entity.setAmount( dto.getAmount() );
        }
        if ( dto.getPaymentDate() != null ) {
            entity.setPaymentDate( dto.getPaymentDate() );
        }

        return entity;
    }
}
