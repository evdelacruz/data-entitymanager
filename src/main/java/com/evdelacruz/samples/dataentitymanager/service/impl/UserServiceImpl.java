package com.evdelacruz.samples.dataentitymanager.service.impl;

import com.evdelacruz.samples.dataentitymanager.service.UserService;
import com.evdelacruz.samples.dataentitymanager.service.contract.UserBinder;
import com.evdelacruz.samples.dataentitymanager.service.contract.vo.ProfileVO;
import com.evdelacruz.samples.dataentitymanager.service.contract.vo.UserSearchCriteriaVO;
import com.evdelacruz.samples.dataentitymanager.service.contract.vo.UserVO;
import com.evdelacruz.samples.dataentitymanager.service.datasource.UserRepository;
import com.evdelacruz.samples.dataentitymanager.util.exceptions.EntityNotFoundException;
import com.evdelacruz.samples.dataentitymanager.util.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Stream;
import static com.evdelacruz.samples.dataentitymanager.service.contract.UserBinder.*;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    private @Autowired UserRepository userRepository;

    public UserServiceImpl() {}

    @Override
    public int add(UserVO user) {
        return userRepository.save(bind(user)).getId();
    }

    @Override
    public void update(int id, ProfileVO profile) {
        userRepository.find(id).ifPresent(user -> bind(profile, user.getProfile()));
    }

    @Override
    public void remove(int id) {
        this.userRepository.delete(id);
    }

    @Override
    @Transactional(readOnly=true)
    public UserVO load(int id) {
        return userRepository.find(id).map(UserBinder::bind).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional(readOnly=true)
    public Stream<UserVO> loadAll(UserSearchCriteriaVO criteria) {
        return userRepository.search(bind(criteria)).map(UserBinder::bind);
    }
}
