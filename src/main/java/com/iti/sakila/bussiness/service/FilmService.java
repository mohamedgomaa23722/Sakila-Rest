package com.iti.sakila.bussiness.service;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.MessageBuilder;
import com.iti.sakila.bussiness.dtos.categorydto.CategoryDto;
import com.iti.sakila.bussiness.dtos.filmdtos.FilmActorDto;
import com.iti.sakila.bussiness.dtos.filmdtos.FilmDto;
import com.iti.sakila.bussiness.exceptions.ExistException;
import com.iti.sakila.bussiness.exceptions.InputDataException;
import com.iti.sakila.bussiness.exceptions.InputDataValidator;
import com.iti.sakila.bussiness.exceptions.NotExistException;
import com.iti.sakila.bussiness.mapper.filmmapper.FilmActorMapper;
import com.iti.sakila.bussiness.mapper.filmmapper.FilmCategoryMapper;
import com.iti.sakila.bussiness.mapper.filmmapper.FilmMapper;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.entity.*;
import com.iti.sakila.persistance.repository.BaseRepository;
import com.iti.sakila.persistance.repository.FilmRepository;
import com.iti.sakila.utils.FilterRecord;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class FilmService extends BaseService<Film, FilmDto> {
    private final FilmRepository filmRepository = new FilmRepository();
    private final BaseRepository<Language> languageBaseRepository = new BaseRepository<>(Language.class);
    private final BaseRepository<FilmActor> filmActorBaseRepository = new BaseRepository<>(FilmActor.class);
    private final BaseRepository<FilmCategory> filmCategoryBaseRepository = new BaseRepository<>(FilmCategory.class);

    public FilmService() {
        super(Film.class, FilmMapper.INSTANCE);
    }

    /**
     * To Insert film so we need to follow those steps :
     * 1- check if film is exist (Done)
     * 2- check if language is exist
     * 4- return message whether it was 200 or 500
     *
     * @param filmDto
     * @return
     */
    public Message insertFilm(FilmDto filmDto) {
        return Database.doInTransaction(entityManager -> {
            if (!InputDataValidator.isValidData(filmDto))
                throw new InputDataException(InputDataValidator.validateMessage().toString());


            Film film = FilmMapper.INSTANCE.toEntity(filmDto);

            film.setLastUpdate(new Timestamp(new Date().getTime()));

            //Check if film is exist
            if (isExist(film.getTitle(), "title") != null) {
                throw new ExistException("fail to insert film with title = " + film.getTitle() + "to Database because film is exist into our database");
            }

            //Check if language is existed
            String languageName = filmDto.getLanguageName().substring(0, 1).toUpperCase() + filmDto.getLanguageName().toLowerCase().substring(1);
            Language language = languageBaseRepository.isExist(languageName, "name", entityManager);
            if (language != null)
                film.setLanguageByLanguageId(language);

            //Insert film
            Film insertedFilm = filmRepository.insert(film, entityManager);

            //then insert its film actors
            for (FilmActorDto filmActor : filmDto.getActors()) {
                FilmActor insertedActor = filmActorBaseRepository.insert(FilmActorMapper.INSTANCE.from(filmActor, insertedFilm), entityManager);
                if (insertedActor == null)
                    throw new NotExistException("Make sure that actor id = " + filmActor.getActorActorId() + " is exist.");
            }

            //then insert category of film
            for (CategoryDto categoryDto : filmDto.getCategories()) {
                FilmCategory filmCategory = filmCategoryBaseRepository.insert(FilmCategoryMapper.INSTANCE.toEntity(categoryDto, insertedFilm), entityManager);
                if (filmCategory == null)
                    throw new NotExistException("Make sure that category id = " + categoryDto.getCategoryId() + " is exist.");
            }

            return new MessageBuilder(200)
                    .setMessage("successfully insert film")
                    .setDescription("fail to insert film  with id =" + insertedFilm.getFilmId() + "to Database ")
                    .build();
        });
    }

    public List<FilmDto> findFilmWithMultipleFilters(FilterRecord filterRecord) {
        return Database.doInTransaction(entityManager -> super.baseMapper.toDtoList(filmRepository
                .findFilmWithMultipleFilters(filterRecord, entityManager)));
    }
}