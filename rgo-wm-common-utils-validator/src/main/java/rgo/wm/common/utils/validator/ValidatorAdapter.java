package rgo.wm.common.utils.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;

public class ValidatorAdapter {

    private final Validator validator;

    public ValidatorAdapter(Validator validator) {
        this.validator = validator;
    }

    public <T> List<String> validate(T t) {
        Set<ConstraintViolation<T>> violations = validator.validate(t);
        return ConstraintViolations.messages(violations);
    }
}
