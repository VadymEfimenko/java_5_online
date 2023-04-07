package ua.com.alevel.dao.impl;


import org.springframework.stereotype.Service;
import ua.com.alevel.entity.BaseEntity;

import java.util.List;

@Service
public class EntityStorage<E extends BaseEntity> {

    public List<E> add(E entity, List<E> storage) {
        storage.add(entity);
        return storage;
    }

    public List<E> update(E entity, List<E> storage) {
        E updatedEntity = findById(entity.getId(), storage);
        storage.set(storage.indexOf(updatedEntity), entity);
        return storage;
    }

    public List<E> delete(Long id, List<E> storage) {
        E e = findById(id, storage);
        storage.remove(e);
        return storage;
    }

    public E findById(Long id, List<E> storage) {
        for (E e : storage) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }
}
