package com.evdelacruz.samples.dataentitymanager.util.constraint;

import javax.validation.ConstraintViolation;
import javax.validation.ElementKind;
import javax.validation.Path;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

public final class ConstraintViolationUtils {

    static public String extractFields(Collection<ConstraintViolation<?>> violations) {
        return violations.stream().map(ConstraintViolationUtils::transform).collect(Collectors.joining(", "));
    }

    static private String transform(ConstraintViolation<?> violation) {
        Iterator<Path.Node> it = violation.getPropertyPath().iterator();
        StringBuilder builder = new StringBuilder();
        Path.Node node;
        do {
            node = it.next();
            if (node.getKind() == ElementKind.PROPERTY) {
                if (it.hasNext()) {
                    builder.append(node).append(".");
                } else {
                    builder.append(node);
                }
            }
        } while (it.hasNext());
        return builder.toString();
    }

    private ConstraintViolationUtils() {
        throw new AssertionError("No 'ConstraintViolationUtils' instances for you !!!");
    }
}
