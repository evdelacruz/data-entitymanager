package com.evdelacruz.samples.dataentitymanager.dist.rest;

import com.evdelacruz.samples.dataentitymanager.util.error.Error;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.status;

@RestController
public class BasicErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value="/error/{code}")
    public ResponseEntity<Error> error(@PathVariable(required=false) int code) {
        switch (code) {
            case 401:
                return status(HttpStatus.UNAUTHORIZED).body(new Error("E2", "UNAUTHORIZED"));
            case 403:
                return status(HttpStatus.FORBIDDEN).body(new Error("E2", "FORBIDDEN"));
            case 404:
                return notFound().build();
            default://500
                return status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error("E1", "INTERNAL SERVER ERROR"));
        }
    }
}
