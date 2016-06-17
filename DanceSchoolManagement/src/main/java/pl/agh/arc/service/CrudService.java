package pl.agh.arc.service;

import pl.agh.arc.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Arek on 2016-06-17.
 */
public interface CrudService<T extends BaseEntity> {

    T save(T t);

    T get(Serializable id);

    List<T> getAll();

    void delete(Serializable id);
}
