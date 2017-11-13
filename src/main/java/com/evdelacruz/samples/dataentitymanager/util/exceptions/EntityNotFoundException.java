package com.evdelacruz.samples.dataentitymanager.util.exceptions;

public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -9212835868236815378L;

    public EntityNotFoundException() {}

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }
}
