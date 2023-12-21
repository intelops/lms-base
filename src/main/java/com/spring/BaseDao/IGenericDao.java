package com.spring.BaseDao;

import java.io.Serializable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import com.spring.model.Event;
import com.spring.model.User;
@Repository
@Transactional
public interface IGenericDao<T extends Serializable> {
    void setClazz(Class< T > clazzToSet);

    T findOne(final int id);

    List<T> findAll();

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final int entityId);

	//void save(final T Entity);
}