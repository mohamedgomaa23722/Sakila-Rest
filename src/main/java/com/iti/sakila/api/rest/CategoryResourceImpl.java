package com.iti.sakila.api.rest;

import com.iti.sakila.api.dtos.categorydtos.InsertCategoryRequest;
import com.iti.sakila.api.dtos.categorydtos.UpdateCategoryRequest;
import com.iti.sakila.bussiness.dtos.categorydto.CategoryDto;
import com.iti.sakila.bussiness.mapper.filmmapper.CategoryMapper;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.bussiness.service.BaseTransactionService;
import com.iti.sakila.persistance.entity.Category;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("v1/categories")
public class CategoryResourceImpl {

    private final BaseService<Category, CategoryDto> baseService = new BaseTransactionService<>(Category.class, CategoryMapper.INSTANCE);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories(@DefaultValue("1") @QueryParam("page") int page) {
        List<CategoryDto> categories = baseService.getAll(page);
        return Response.ok().entity(categories).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategory(@PathParam("id") int id) {
        return Response.ok().entity(baseService.findById(id)).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertCategory(InsertCategoryRequest insertCategoryRequest) {
        CategoryDto categoryDto = CategoryMapper.INSTANCE.fromInsertCategoryRequest(insertCategoryRequest);
        return Response.ok().entity(baseService.insert(categoryDto)).build();

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCategory(UpdateCategoryRequest updateCategoryRequest) {
        CategoryDto categoryDto = CategoryMapper.INSTANCE.fromUpdateCategoryRequest(updateCategoryRequest);
        return Response.ok().entity(baseService.update(categoryDto, categoryDto.getCategoryId())).build();

    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCategory(@PathParam("id") int id) {
        return Response.ok().entity(baseService.delete(id)).build();

    }

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCategoriesByName(@QueryParam("name") String name,
                                         @DefaultValue("1") @QueryParam("page") int page) {
        return Response.ok().entity(baseService.findByName(name, "name", page)).build();
    }

    @GET
    @Path("{id}/films")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCategoryFilms(@PathParam("id") int id){
        CategoryDto category = baseService.findById(id);
        return Response.ok().entity(category.getFilms()).build();
    }
}
