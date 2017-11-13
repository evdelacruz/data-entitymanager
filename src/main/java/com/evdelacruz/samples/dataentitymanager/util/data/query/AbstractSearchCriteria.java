package com.evdelacruz.samples.dataentitymanager.util.data.query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.function.Supplier;

public abstract class AbstractSearchCriteria<E> implements SearchCriteria<E> {
    private Predicate[] predicates;
    private int index;

    public AbstractSearchCriteria() {
        this.predicates = new Predicate[5];
        this.index = 0;
    }

    protected void addPredicate(Supplier<Predicate> function) {
        this.ensureCapacity();
        predicates[index++] = function.get();
    }

    protected void addPredicate(Supplier<Boolean> condition, Supplier<Predicate> function) {
        if (condition.get()) {
            this.addPredicate(function);
        }
    }

    public Predicate build(CriteriaBuilder builder) {
        if (index == 0) {
            return null;
        }
        if (index == 1) {
            return predicates[0];
        }
        return builder.and(index < predicates.length ? Arrays.copyOf(predicates, index) : predicates);
    }

    private void ensureCapacity() {
        if (index < predicates.length)
            return;
        predicates = Arrays.copyOf(predicates, predicates.length + 5);
    }
}
