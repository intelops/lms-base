package com.spring.BaseDaoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.base.Preconditions;

import com.spring.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaDAO<T extends Serializable> {
    private Class<T> clazz;

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    public  void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }
   // public void setClazz(final Class<T> clazzToSet) {
	//	clazz = Preconditions.checkNotNull(clazzToSet);
	//}

    public T findOne(final int id) {
        return  entityManager.find(clazz, id);
    }
  
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }
   // public List<T> findAll() {
		//return getCurrentSession().createQuery("from " + clazz.getName()).list();
	//}

    public T create(final T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T update(final T entity) {
        return entityManager.merge(entity);
    }

    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(final int entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }
}
