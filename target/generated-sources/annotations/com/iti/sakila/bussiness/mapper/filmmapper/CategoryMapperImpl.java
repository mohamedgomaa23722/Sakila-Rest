package com.iti.sakila.bussiness.mapper.filmmapper;

import com.iti.sakila.api.dtos.categorydtos.InsertCategoryRequest;
import com.iti.sakila.api.dtos.categorydtos.UpdateCategoryRequest;
import com.iti.sakila.bussiness.dtos.categorydto.CategoryDto;
import com.iti.sakila.persistance.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T04:23:15+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public List<CategoryDto> toDtoList(List<Category> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryDto> list1 = new ArrayList<CategoryDto>( list.size() );
        for ( Category category : list ) {
            list1.add( toDto( category ) );
        }

        return list1;
    }

    @Override
    public Category toEntity(CategoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( dto.getCategoryId() );
        category.setName( dto.getName() );

        return category;
    }

    @Override
    public CategoryDto toDto(Category entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId( entity.getCategoryId() );
        categoryDto.setName( entity.getName() );

        return categoryDto;
    }

    @Override
    public Category partialUpdate(CategoryDto dto, Category entity) {
        if ( dto == null ) {
            return entity;
        }

        entity.setCategoryId( dto.getCategoryId() );
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }

        return entity;
    }

    @Override
    public CategoryDto fromInsertCategoryRequest(InsertCategoryRequest insertCityRequest) {
        if ( insertCityRequest == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setName( insertCityRequest.getName() );

        return categoryDto;
    }

    @Override
    public CategoryDto fromUpdateCategoryRequest(UpdateCategoryRequest updateCityRequest) {
        if ( updateCityRequest == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId( updateCityRequest.getCategoryId() );
        categoryDto.setName( updateCityRequest.getName() );

        return categoryDto;
    }
}
