package com.iti.sakila.api.rest.interfaces;

import com.iti.sakila.api.dtos.categorydtos.InsertCategoryRequest;
import com.iti.sakila.api.dtos.categorydtos.UpdateCategoryRequest;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.categorydto.CategoryDto;
import jakarta.ws.rs.core.Response;

import java.util.List;

public interface CategoryResource {
    List<CategoryDto> getCategories(int page);

    CategoryDto getCategory(int id);

    Message insertCategory(InsertCategoryRequest insertCategoryRequest);

    Message updateCategory(UpdateCategoryRequest updateCategoryRequest);

    Message deleteCategory(int id);

    Response findCategoriesByName(String name, int page);
}
