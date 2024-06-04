package rgo.wm.common.utils.validator.rule;

public class IntegerNonNegativeValidationRule implements ValidationRule<Integer> {

    @Override
    public ValidationRuleResult validate(Integer integer) {
        if (integer < 0) {
            return ValidationRuleResult.failed("The value must not be negative.");
        }
        return ValidationRuleResult.passed();
    }
}
