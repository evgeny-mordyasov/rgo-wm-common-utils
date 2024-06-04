package rgo.wm.common.utils.validator;

import javax.annotation.Nonnull;

public class ValidationEngine {

    private final ValidatorRegistry registry;

    public ValidationEngine(ValidatorRegistry registry) {
        this.registry = registry;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void validate(@Nonnull Object object, @Nonnull String parameterName) {
        Validator validator = registry.getValidator(object.getClass());
        ValidationResult result = validator.validate(object);
        if (result.isFailed()) {
            throw new ValidationException(String.format("[%s]: %s (%s/%s)",
                    parameterName, result.getErrorMessage(), result.getPassedRules(), result.getTotalRules()));
        }
    }
}
