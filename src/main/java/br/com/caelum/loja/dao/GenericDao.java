package br.com.caelum.loja.dao;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Transactional
public abstract class GenericDao<T, I extends Serializable> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> persistedClass;

    protected GenericDao() {
    }

    protected GenericDao(Class<T> persistedClass) {
        this();
        this.persistedClass = persistedClass;
    }

    public T save(T entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }

    public T update(T entity) {
        entityManager.merge(entity);
        entityManager.flush();
        return entity;
    }

    public void remove(I id) {
        T entity = findById(id);
        T mergedEntity = entityManager.merge(entity);
        entityManager.remove(mergedEntity);
        entityManager.flush();
    }

    public List<T> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        return entityManager.createQuery(query).getResultList();
    }

    public T findById(I id) {
        return entityManager.find(persistedClass, id);
    }
}
