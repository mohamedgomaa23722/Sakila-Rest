package com.iti.sakila.persistance.repository;

import com.iti.sakila.persistance.entity.Actor;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.persistance.entity.FilmActor;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ActorRepository extends BaseRepository<Actor> {
    public ActorRepository() {
        super(Actor.class);
    }
}
