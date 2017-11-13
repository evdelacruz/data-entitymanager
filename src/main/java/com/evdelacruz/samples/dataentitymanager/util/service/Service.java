package com.evdelacruz.samples.dataentitymanager.util.service;

import org.springframework.validation.annotation.Validated;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Validated
@org.springframework.stereotype.Service
public @interface Service {
    String value() default "";
}
