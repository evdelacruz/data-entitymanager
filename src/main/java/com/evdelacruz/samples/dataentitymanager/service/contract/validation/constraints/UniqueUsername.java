package com.evdelacruz.samples.dataentitymanager.service.contract.validation.constraints;

import com.evdelacruz.samples.dataentitymanager.service.contract.validation.validators.UniqueUsernameValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy=UniqueUsernameValidator.class)
public @interface UniqueUsername {

    String message() default "UniqueUsername.message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
