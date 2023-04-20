package com.iti.sakila.api.rest.impl;

import com.iti.sakila.api.dtos.filmdtos.InsertFilmRequest;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.filmdtos.FilmDto;
import com.iti.sakila.bussiness.exceptions.InputDataException;
import com.iti.sakila.bussiness.mapper.filmmapper.FilmMapper;
import com.iti.sakila.bussiness.service.FilmService;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.utils.FilterRecord;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.List;

@Path("v1/films")
public class FilmResource {
    FilmService filmService = new FilmService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificFilm(@DefaultValue("1") @QueryParam("page") int page,
                                    @DefaultValue("0") @QueryParam("categoryId") int categoryId,
                                    @DefaultValue("0") @QueryParam("cost") int cost,
                                    @DefaultValue("0") @QueryParam("rate") int rate,
                                    @DefaultValue("") @QueryParam("name") String name) {
        FilterRecord filterRecord = new FilterRecord(page,
                categoryId,
                new BigDecimal(cost),
                new BigDecimal(rate),
                name);
        List<FilmDto> films = filmService.findFilmWithMultipleFilters(filterRecord);
        return Response.ok().entity(films).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findFilmById(@PathParam("id") int id) {
        FilmDto filmResponse = filmService.findById(id);
        return Response.ok().entity(filmResponse).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response insertFilm(FilmDto film) throws InputDataException {
        System.out.println("dto = " + film);
        Message message = filmService.insertFilm(film);
        return Response.ok().entity(message).build();
    }
}