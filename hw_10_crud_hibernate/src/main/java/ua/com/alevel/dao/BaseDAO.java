package ua.com.alevel.dao;

import ua.com.alevel.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<E extends BaseEntity> {

    void create(E entity);

    void update(E entity);

    void delete(E entity);

    Optional<E> findById(Long id);

    List<E> findAll();
}
