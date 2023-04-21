package com.iti.sakila.api.rest;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.actordto.ActorDto;
import com.iti.sakila.bussiness.dtos.actordto.ActorFilmDto;
import com.iti.sakila.bussiness.mapper.actormapper.ActorMapper;
import com.iti.sakila.bussiness.service.ActorService;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.persistance.entity.Actor;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Set;

@Path("v1/actors")
public class ActorResource {
    private final ActorService actorService;

    public ActorResource() {
        actorService = new ActorService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActors(@DefaultValue("1") @QueryParam("page") int page) {
        return Response.ok().entity(actorService.getAll(page)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertActor(ActorDto actor) {
        Message meessage = actorService.insert(actor);
        return Response.ok().entity(meessage).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActor(@PathParam("id") int id) {
        return Response.ok().entity(actorService.findById(id)).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response DeleteActor(@PathParam("id") int id) {
        return Response.ok().entity(actorService.delete(id)).build();
    }

    @GET
    @Path("{id}/filmActors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findActorFilms(@PathParam("id") int id) {
        List<ActorFilmDto> actors = actorService.findActorFilms(id);
        return Response.ok().entity(actors).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateActor(ActorDto actorDto, @PathParam("id") int id){
        actorDto.setActorId((short) id);
        Message update = actorService.update(actorDto, id);
        return Response.ok().entity(update).build();
    }
}
