package rgo.wm.common.utils.validator;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

public final class Validators {

    private Validators() {
    }

    public static ValidatorAdapter createValidator() {
        try (var factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory()
        ) {
            Validator validator = factory.usingContext().getValidator();
            return new ValidatorAdapter(validator);
        }
    }
}
