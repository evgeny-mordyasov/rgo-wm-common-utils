package rgo.wm.common.utils.validator;

import rgo.wm.common.utils.validator.rule.IntegerNonNegativeValidationRule;
import rgo.wm.common.utils.validator.rule.StringNonEmptyValidationRule;
import rgo.wm.common.utils.validator.rule.StringNonNullValidationRule;

import java.util.List;

public final class Validators {

    private Validators() {
    }

    public static ValidationEngine defaultValidator() {
        return new ValidationEngine(
                new ValidatorRegistry(
                        List.of(
                                new StringValidator(
                                        List.of(
                                               new StringNonNullValidationRule(),
                                               new StringNonEmptyValidationRule()
                                        )
                                ),
                                new IntegerValidator(
                                        List.of(
                                                new IntegerNonNegativeValidationRule()
                                        )
                                )
                        )
                )
        );
    }
}
