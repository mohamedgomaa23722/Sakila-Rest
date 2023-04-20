package com.iti.sakila.bussiness.service;

import com.iti.sakila.bussiness.dtos.*;
import com.iti.sakila.bussiness.dtos.actordto.ActorDto;
import com.iti.sakila.bussiness.dtos.actordto.ActorFilmDto;
import com.iti.sakila.bussiness.mapper.BaseMapper;
import com.iti.sakila.bussiness.mapper.actormapper.ActorFilmMapper;
import com.iti.sakila.bussiness.mapper.actormapper.ActorMapper;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.entity.Actor;
import com.iti.sakila.persistance.entity.FilmActor;
import com.iti.sakila.persistance.repository.ActorRepository;
import com.iti.sakila.persistance.repository.BaseRepository;
import jakarta.persistence.EntityManager;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ActorService extends BaseService<Actor, ActorDto> {

    public ActorService() {
        super(Actor.class, ActorMapper.INSTANCE);
    }

    public List<ActorFilmDto> findActorFilms(int actorId) {
        return Database.doInTransaction(entityManager -> {
            List<FilmActor> filmActors = repository.findById(actorId, entityManager).getFilmActors().stream().toList();
            return ActorFilmMapper.INSTANCE.toDtoList(filmActors);
        });
    }

}
