package rgo.wm.common.utils.validator.rule;

public class StringNonEmptyValidationRule implements ValidationRule<String> {

    @Override
    public ValidationRuleResult validate(String s) {
        if (s.isEmpty()) {
            return ValidationRuleResult.failed("The value must not be empty.");
        }
        return ValidationRuleResult.passed();
    }
}
