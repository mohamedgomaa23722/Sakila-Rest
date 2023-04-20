package com.iti.sakila.bussiness.service;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.MessageBuilder;
import com.iti.sakila.bussiness.exceptions.InputDataException;
import com.iti.sakila.bussiness.exceptions.InputDataValidator;
import com.iti.sakila.bussiness.exceptions.NotExistException;
import com.iti.sakila.bussiness.mapper.BaseMapper;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.repository.BaseRepository;

import java.util.List;

public class BaseService<T, R> implements ServiceInterface<T, R> {
    protected final BaseRepository<T> repository;

    protected final Class<T> src;
    protected final BaseMapper<T, R> baseMapper;

    public BaseService(Class<T> src, BaseMapper<T, R> baseMapper) {
        this.repository = new BaseRepository<>(src);
        this.src = src;
        this.baseMapper = baseMapper;
    }

    @Override
    public List<R> getAll(int page) {
        return Database.doInTransaction(entityManager -> baseMapper.toDtoList(repository.getAll(page, entityManager)));
    }

    @Override
    public Message insert(R object) {
        return Database.doInTransaction(entityManager -> {
            if (!InputDataValidator.isValidData(object))
                throw new InputDataException(InputDataValidator.validateMessage().toString());
            T entity = baseMapper.toEntity(object);
            T insertedEntity = repository.insert(entity, entityManager);
            return generateMessage(baseMapper.toDto(insertedEntity));
        });
    }

    @Override
    public Message update(R dto, int id) {
        return Database.doInTransaction(entityManager -> {
            boolean isUpdated = repository.update(baseMapper.toEntity(dto), id, entityManager);
            if (!isUpdated)
                throw new NotExistException("Can't update item with id = " + id + " check the id and try again later.");
            else
                return generateMessage(dto);
        });
    }

    @Override
    public Message delete(int id) {
        return Database.doInTransaction(entityManager -> {
            boolean isDeleted = repository.delete(id, entityManager);
            if (!isDeleted)
                throw new NotExistException("Can't delete item with id = " + id + " check the id and try again later.");
            else
                return generateMessage(id);
        });
    }

    @Override
    public R findById(int id) {
        return Database.doInTransaction(entityManager -> {
            T entity = repository.findById(id, entityManager);
            return baseMapper.toDto(entity);
        });
    }

    @Override
    public List<R> findByName(String name, String fieldName, int page) {
        return Database.doInTransaction(entityManager -> baseMapper.toDtoList(repository.findByName(name, fieldName, page, entityManager)));
    }

    @Override
    public T isExist(String name, String fieldName) {
        return Database.doInTransaction(entityManager -> repository.isExist(name, fieldName, entityManager));
    }

    public Message generateMessage(Object object) {
        return new MessageBuilder()
                .setSuccessfullyMessage("Successfull operation")
                .setSuccessfully(true)
                .setObject(object)
                .build();
    }
}
