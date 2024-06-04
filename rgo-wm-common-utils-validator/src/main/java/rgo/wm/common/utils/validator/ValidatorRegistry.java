package rgo.wm.common.utils.validator;

import rgo.wm.common.utils.asserts.Asserts;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValidatorRegistry {

    private static final Validator<Object> UNKNOWN_VALIDATOR = new UnknownValidator();

    private final Map<Class<?>, Validator<?>> validators;

    public ValidatorRegistry(List<Validator<?>> validators) {
        this.validators = Asserts.nonEmpty(validators, "'validators' must not be empty")
                .stream()
                .collect(Collectors.toMap(Validator::getType, Function.identity()));
    }

    @Nonnull
    @SuppressWarnings("unchecked")
    public <T> Validator<T> getValidator(Class<T> clazz) {
        return (Validator<T>) validators.getOrDefault(clazz, UNKNOWN_VALIDATOR);
    }
}
