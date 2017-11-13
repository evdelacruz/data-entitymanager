package com.evdelacruz.samples.dataentitymanager.service;

import com.evdelacruz.samples.dataentitymanager.service.contract.vo.ProfileVO;
import com.evdelacruz.samples.dataentitymanager.service.contract.vo.UserSearchCriteriaVO;
import com.evdelacruz.samples.dataentitymanager.service.contract.vo.UserVO;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.stream.Stream;

public interface UserService {

    int add(@Valid UserVO user);

    void update(@Min(1) int id, @Valid ProfileVO profile);

    void remove(@Min(1) int id);

    UserVO load(@Min(1) int id);

    Stream<UserVO> loadAll(@Valid UserSearchCriteriaVO criteria);
}
