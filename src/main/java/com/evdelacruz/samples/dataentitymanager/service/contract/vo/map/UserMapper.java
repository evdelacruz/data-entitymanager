package com.evdelacruz.samples.dataentitymanager.service.contract.vo.map;

import com.evdelacruz.samples.dataentitymanager.service.contract.vo.ProfileVO;
import com.evdelacruz.samples.dataentitymanager.service.contract.vo.UserSearchCriteriaVO;
import com.evdelacruz.samples.dataentitymanager.service.contract.vo.UserVO;
import com.evdelacruz.samples.dataentitymanager.service.datasource.domain.Profile;
import com.evdelacruz.samples.dataentitymanager.service.datasource.domain.User;
import com.evdelacruz.samples.dataentitymanager.service.datasource.query.UserSearchCriteria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User map(UserVO source);

    @Mapping(target="id", ignore=true)
    @Mapping(target="user", ignore=true)
    Profile map(ProfileVO source);

    @Mapping(target="id", ignore=true)
    @Mapping(target="user", ignore=true)
    void map(ProfileVO source, @MappingTarget Profile target);

    UserVO map(User source);

    UserSearchCriteria map(UserSearchCriteriaVO source);
}
