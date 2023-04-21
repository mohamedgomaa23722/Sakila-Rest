package com.iti.sakila.api.rest;

import com.iti.sakila.api.dtos.citydtos.InsertCityRequest;
import com.iti.sakila.api.dtos.citydtos.UpdateCityRequest;
import com.iti.sakila.bussiness.dtos.addressdtos.CityDto;
import com.iti.sakila.bussiness.dtos.countrydtos.CountryDto;
import com.iti.sakila.bussiness.mapper.CityMapper;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.bussiness.service.BaseTransactionService;
import com.iti.sakila.persistance.entity.City;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("v1/cities")
public class CityResource {

    private final BaseService<City, CityDto> baseService = new BaseTransactionService<>(City.class, CityMapper.INSTANCE);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCities(@DefaultValue("1") @QueryParam("page") int page) {
        return Response.ok().entity(baseService.getAll(page)).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCity(@PathParam("id") int id) {
        return Response.ok().entity(baseService.findById(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertCity(InsertCityRequest insertCityRequest) {
        CityDto city = CityMapper.INSTANCE.fromInsertCityRequest(insertCityRequest);
        return Response.ok().entity(baseService.insert(city)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCity(UpdateCityRequest updateCityRequest) {
        CityDto city = CityMapper.INSTANCE.fromUpdateCityRequest(updateCityRequest);
        return Response.ok().entity(baseService.update(city, city.getCityId())).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCity(@PathParam("id") int id) {
        return Response.ok().entity(baseService.delete(id)).build();
    }

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCitiesByName(@QueryParam("name") String name,
                                          @DefaultValue("1") @QueryParam("page") int page) {
        List<CityDto> city = baseService.findByName(name, "city", page);
        System.out.println(name + page);
        System.out.println(city);
        return Response.ok().entity(city).build();

    }
}
