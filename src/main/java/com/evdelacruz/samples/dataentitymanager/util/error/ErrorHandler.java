package com.evdelacruz.samples.dataentitymanager.util.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class ErrorHandler<R> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Map<Class<? extends Exception>, Function<Exception, R>> responses;
    private R defaultResponse;

    public ErrorHandler() {
        responses = new HashMap<>();
        this.initialize(responses);
    }

    public R handleError(Exception ex) {
        if (responses.containsKey(ex.getClass())) {
            logger.debug("An expected error has ocurred", ex);
            return responses.get(ex.getClass()).apply(ex);
        }
        logger.error("An unexpected error has ocurred", ex);
        return this.defaultResponse;
    }

    public abstract void initialize(Map<Class<? extends Exception>, Function<Exception, R>> responses);

    //<editor-fold desc="Encapsulation">
    public final void setDefaultResponse(R defaultResponse) {
        this.defaultResponse = defaultResponse;
    }
    //</editor-fold>
}
