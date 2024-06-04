package rgo.wm.common.utils.validator;

import rgo.wm.common.utils.validator.rule.ValidationRule;
import rgo.wm.common.utils.validator.rule.ValidationRuleResult;

import java.util.List;

public abstract class AbstractValidator<T> implements Validator<T> {

    private final List<ValidationRule<T>> steps;

    protected AbstractValidator(List<ValidationRule<T>> steps) {
        this.steps = steps;
    }

    @Override
    public ValidationResult validate(T t) {
        int passedRules = 0;
        for (var step : steps) {
            ValidationRuleResult result = step.validate(t);
            if (result.isFailed()) {
                return ValidationResult.failed(steps.size(), passedRules, result.getErrorMessage());
            }
            passedRules++;
        }
        return ValidationResult.passed(steps.size());
    }
}
