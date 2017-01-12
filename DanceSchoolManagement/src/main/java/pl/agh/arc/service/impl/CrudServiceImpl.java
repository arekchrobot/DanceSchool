package pl.agh.arc.service.impl;

import org.springframework.data.repository.CrudRepository;
import pl.agh.arc.domain.BaseEntity;
import pl.agh.arc.service.CrudService;
import pl.agh.arc.util.HibernateLazyInitiator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Arek on 2016-06-17.
 */
public abstract class CrudServiceImpl<T extends BaseEntity> implements CrudService<T> {

    protected abstract CrudRepository<T, Long> getRepository();

    @Override
    public T save(T entity) {
        entity = getRepository().save(entity);
        return entity;
    }

    @Override
    public T get(Long id) {
        T entity = getRepository().findOne(id);
        HibernateLazyInitiator.init(entity);
        return entity;
    }

    @Override
    public List<T> getAll() {
        List<T> entities = (List<T>) getRepository().findAll();
        HibernateLazyInitiator.initList(entities);
        return entities;
    }

    @Override
    public void delete(Long id) {
        getRepository().delete(id);
    }
}
