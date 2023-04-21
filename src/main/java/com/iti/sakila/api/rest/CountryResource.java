package com.iti.sakila.api.rest;

import com.iti.sakila.api.dtos.countrydtos.CountryResponse;
import com.iti.sakila.api.dtos.countrydtos.InsertCountryRequest;
import com.iti.sakila.api.dtos.countrydtos.UpdateCountryRequest;
import com.iti.sakila.bussiness.dtos.countrydtos.CountryDto;
import com.iti.sakila.bussiness.mapper.CountryMapper;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.bussiness.service.BaseTransactionService;
import com.iti.sakila.persistance.entity.Country;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("v1/countries")
public class CountryResource {
    private final BaseService<Country, CountryDto> baseService = new BaseTransactionService<>(Country.class, CountryMapper.INSTANCE);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountries(@DefaultValue("1") @QueryParam("page") int page) {
        List<CountryResponse> countries = CountryMapper.INSTANCE.toCountriesResponse(baseService.getAll(page));
        return Response.ok().entity(countries).build();

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountry(@PathParam("id") int id) {
        return Response.ok().entity(baseService.findById(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertCountry(InsertCountryRequest insertCountryRequest) {
        System.out.println(insertCountryRequest);
        CountryDto country = CountryMapper.INSTANCE.fromInsertCountryRequest(insertCountryRequest);
        return Response.ok().entity(baseService.insert(country)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCountry(UpdateCountryRequest updateCountryRequest) {
        System.out.println(updateCountryRequest);
        CountryDto country = CountryMapper.INSTANCE.fromUpdateCountryRequest(updateCountryRequest);
        return Response.ok().entity(baseService.update(country, country.getCountryId())).build();

    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCountry(@PathParam("id") int id) {
        return Response.ok().entity(baseService.delete(id)).build();
    }

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCountriesByName(@QueryParam("name") String name,
                                        @DefaultValue("1") @QueryParam("page") int page) {
        return Response.ok().entity(baseService.findByName(name, "country", page)).build();
    }

    @GET
    @Path("{id}/cities")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCountriesCities(@PathParam("id") int id){
        CountryDto country = baseService.findById(id);
        return Response.ok().entity(country.getCities()).build();
    }
}