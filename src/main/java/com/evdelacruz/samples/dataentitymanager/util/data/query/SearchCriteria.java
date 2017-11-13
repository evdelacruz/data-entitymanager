package com.evdelacruz.samples.dataentitymanager.util.data.query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface SearchCriteria<E> {

    Predicate getPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder builder);
}
