package rgo.wm.common.utils.validator.rule;

public class StringNonNullValidationRule implements ValidationRule<String> {

    @Override
    public ValidationRuleResult validate(String s) {
        if (s == null) {
            return ValidationRuleResult.failed("The value must not be null.");
        }
        return ValidationRuleResult.passed();
    }
}
