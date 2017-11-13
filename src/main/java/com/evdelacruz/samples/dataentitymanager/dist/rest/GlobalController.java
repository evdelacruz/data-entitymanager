package com.evdelacruz.samples.dataentitymanager.dist.rest;

import com.evdelacruz.samples.dataentitymanager.util.error.Error;
import com.evdelacruz.samples.dataentitymanager.util.error.ErrorHandler;
import com.evdelacruz.samples.dataentitymanager.util.exceptions.EntityNotFoundException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import javax.validation.ConstraintViolationException;
import java.util.Map;
import java.util.function.Function;
import static java.util.stream.Collectors.joining;
import static com.evdelacruz.samples.dataentitymanager.util.constraint.ConstraintViolationUtils.extractFields;
import static org.springframework.http.ResponseEntity.*;

@ControllerAdvice
public class GlobalController extends ErrorHandler<ResponseEntity<Error>> {

    public GlobalController() {
        super();
        this.setDefaultResponse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error("E1", "Internal Error")));
    }

    @Override
    public void initialize(Map<Class<? extends Exception>, Function<Exception, ResponseEntity<Error>>> responses) {
        responses.put(ConstraintViolationException.class, ex -> badRequest().body(new Error("E3", extractFields(((ConstraintViolationException) ex).getConstraintViolations()))));
        responses.put(HttpRequestMethodNotSupportedException.class, ex -> notFound().allow(((HttpRequestMethodNotSupportedException) ex).getSupportedHttpMethods().toArray(new HttpMethod[0])).build());
        responses.put(MethodArgumentTypeMismatchException.class, ex -> badRequest().body(new Error("E4", String.format("Invalid format for fields: %s", ((MethodArgumentTypeMismatchException) ex).getName()))));
        responses.put(HttpMessageNotReadableException.class, ex -> badRequest().body(new Error("E4", "Request message is not readable")));
        responses.put(BindException.class, ex -> badRequest().body(new Error("E4", String.format("Invalid format for fields: %s", ((BindException) ex).getFieldErrors().stream().map(FieldError::getField).collect(joining(", "))))));
        responses.put(EntityNotFoundException.class, ex -> notFound().build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex) {
        return this.handleError(ex);
    }
}
