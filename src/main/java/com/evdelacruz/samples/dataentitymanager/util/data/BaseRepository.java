package com.evdelacruz.samples.dataentitymanager.util.data;

import com.evdelacruz.samples.dataentitymanager.util.data.domain.AbstractEntity;
import java.io.Serializable;
import java.util.Optional;

public interface BaseRepository<E extends AbstractEntity, I extends Serializable> {

    E save(E entity);

    void delete(I id);

    void delete(E entity);

    Optional<E> find(I id);
}
