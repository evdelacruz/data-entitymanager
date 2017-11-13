package com.evdelacruz.samples.dataentitymanager.service.datasource.impl;

import com.evdelacruz.samples.dataentitymanager.service.datasource.UserRepository;
import com.evdelacruz.samples.dataentitymanager.service.datasource.domain.User;
import com.evdelacruz.samples.dataentitymanager.service.datasource.query.UserSearchCriteria;
import com.evdelacruz.samples.dataentitymanager.util.data.impl.AbstractRepository;
import org.springframework.stereotype.Repository;
import java.util.stream.Stream;

@Repository("userRepository")
public class UserRepositoryImpl extends AbstractRepository<User, Integer> implements UserRepository {

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public boolean existUsername(String username) {
        Long count = (Long) this.entityManager.createNamedQuery("userrepository.existusername").setParameter(1, username).getSingleResult();
        return null != count && 1 <= count;
    }

    @Override
    public Stream<User> search(UserSearchCriteria criteria) {
        return this.findAll(criteria);
    }
}
