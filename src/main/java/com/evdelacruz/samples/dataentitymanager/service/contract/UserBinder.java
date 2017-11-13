package com.evdelacruz.samples.dataentitymanager.service.contract;

import com.evdelacruz.samples.dataentitymanager.service.contract.vo.ProfileVO;
import com.evdelacruz.samples.dataentitymanager.service.contract.vo.UserSearchCriteriaVO;
import com.evdelacruz.samples.dataentitymanager.service.contract.vo.UserVO;
import com.evdelacruz.samples.dataentitymanager.service.contract.vo.map.UserMapper;
import com.evdelacruz.samples.dataentitymanager.service.datasource.domain.Profile;
import com.evdelacruz.samples.dataentitymanager.service.datasource.domain.User;
import com.evdelacruz.samples.dataentitymanager.service.datasource.query.UserSearchCriteria;

public final class UserBinder {

    static public User bind(UserVO source) {
        return UserMapper.INSTANCE.map(source);
    }

    static public UserSearchCriteria bind(UserSearchCriteriaVO source) {
        return UserMapper.INSTANCE.map(source);
    }

    static public void bind(ProfileVO source, Profile target) {
        UserMapper.INSTANCE.map(source, target);
    }

    static public UserVO bind(User source) {
        return UserMapper.INSTANCE.map(source);
    }

    private UserBinder() {
        throw new AssertionError("No instances of 'UserBinder' for you !!!");
    }
}
