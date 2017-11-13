package com.evdelacruz.samples.dataentitymanager.util.data.impl;

import com.evdelacruz.samples.dataentitymanager.util.data.BaseRepository;
import com.evdelacruz.samples.dataentitymanager.util.data.domain.AbstractEntity;
import com.evdelacruz.samples.dataentitymanager.util.data.query.SearchCriteria;
import com.evdelacruz.samples.dataentitymanager.util.exceptions.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Optional;
import java.util.stream.Stream;

public class AbstractRepository<E extends AbstractEntity, I extends Serializable> implements BaseRepository<E, I> {
    protected @PersistenceContext EntityManager entityManager;
    protected final Class<E> clazz;

    public AbstractRepository(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public E save(E entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public void delete(I id) {
        E entity = this.find(id).orElseThrow(() -> new EntityNotFoundException(String.format("No entity exist with id '%s'", id)));
        this.delete(entity);
    }

    @Override
    public void delete(E entity) {
        this.entityManager.remove(entity);
    }

    @Override
    public Optional<E> find(I id) {
        return Optional.ofNullable(this.entityManager.find(clazz, id));
    }

    protected Stream<E> findAll(SearchCriteria<E> criteria) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<E> query = builder.createQuery(this.clazz);
        Root<E> root = this.applyCriteria(criteria, query, builder);
        return this.entityManager.createQuery(query.select(root)).getResultList().stream();
    }

    private Root<E> applyCriteria(SearchCriteria<E> criteria, CriteriaQuery<E> query, CriteriaBuilder builder) {
        Root<E> root = query.from(this.clazz);
        if (criteria == null) {
            return root;
        }
        Predicate predicate = criteria.getPredicate(root, query, builder);
        if (predicate != null) {
            query.where(predicate);
        }
        return root;
    }
}
