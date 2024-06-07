package rgo.wm.common.utils.validator;

import jakarta.validation.ConstraintViolation;

import java.util.List;
import java.util.Set;

public final class ConstraintViolations {

    private ConstraintViolations() {
    }

    static <T> List<String> messages(Set<ConstraintViolation<T>> violations) {
        return violations.stream().map(ConstraintViolation::getMessage).toList();
    }
}
