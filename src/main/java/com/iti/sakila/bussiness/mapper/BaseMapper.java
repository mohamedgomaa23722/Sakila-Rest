package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.bussiness.dtos.actordto.ActorDto;
import com.iti.sakila.persistance.entity.Actor;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Set;

public interface BaseMapper<T,R>{
    List<R> toDtoList(List<T> list);
    T toEntity(R dto);
    @InheritInverseConfiguration(name = "toEntity")
    R toDto(T entity);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    T partialUpdate(R dto, @MappingTarget T entity);
}
