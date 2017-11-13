package com.evdelacruz.samples.dataentitymanager.service.datasource;

import com.evdelacruz.samples.dataentitymanager.service.datasource.domain.User;
import com.evdelacruz.samples.dataentitymanager.service.datasource.query.UserSearchCriteria;
import com.evdelacruz.samples.dataentitymanager.util.data.BaseRepository;

import java.util.stream.Stream;

public interface UserRepository extends BaseRepository<User, Integer> {

    boolean existUsername(String username);

    Stream<User> search(UserSearchCriteria criteria);
}
