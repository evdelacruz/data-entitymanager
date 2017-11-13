package com.evdelacruz.samples.dataentitymanager.service.contract.validation.validators;

import com.evdelacruz.samples.dataentitymanager.service.contract.validation.constraints.UniqueUsername;
import com.evdelacruz.samples.dataentitymanager.service.datasource.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private @Autowired UserRepository userRepository;

    @Override
    public void initialize(UniqueUsername annotation) {
        //Do nothing
    }

    @Override
    public boolean isValid(String param, ConstraintValidatorContext context) {
        return !userRepository.existUsername(param);
    }
}
