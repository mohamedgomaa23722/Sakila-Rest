package com.iti.sakila.api.rest.impl;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.languagedtos.LanguageDto;
import com.iti.sakila.bussiness.mapper.LanguageMapper;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.persistance.entity.Language;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("v1/languages")
public class LanguageResource {
    private final BaseService<Language, LanguageDto> languageService = new BaseService<>(Language.class, LanguageMapper.INSTANCE);


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LanguageDto> getLanguages(@DefaultValue("1") @QueryParam("page") int page){
        return languageService.getAll(page);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public LanguageDto getLanguage(@PathParam("id") int id){
        return languageService.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Message insertLanguage(LanguageDto languageDto){
        System.out.println("insert lang");
        return languageService.insert(languageDto);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateLanguage(LanguageDto languageDto) {
        return languageService.update(languageDto, languageDto.getLanguageId());
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message deleteLanguage(@PathParam("id")  int id){
        return languageService.delete(id);
    }
}
