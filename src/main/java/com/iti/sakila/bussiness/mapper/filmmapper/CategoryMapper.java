package com.iti.sakila.bussiness.mapper.filmmapper;


import com.iti.sakila.api.dtos.categorydtos.InsertCategoryRequest;
import com.iti.sakila.api.dtos.categorydtos.UpdateCategoryRequest;
import com.iti.sakila.bussiness.dtos.categorydto.CategoryDto;
import com.iti.sakila.bussiness.mapper.BaseMapper;
import com.iti.sakila.persistance.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "default", uses = FilmCategoryMapper.class)
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);


    CategoryDto fromInsertCategoryRequest(InsertCategoryRequest insertCityRequest);

    CategoryDto fromUpdateCategoryRequest(UpdateCategoryRequest updateCityRequest);
}
