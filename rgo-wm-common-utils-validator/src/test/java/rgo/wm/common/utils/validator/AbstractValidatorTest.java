package rgo.wm.common.utils.validator;

import org.junit.jupiter.api.Test;
import rgo.wm.common.utils.validator.rule.ValidationRule;
import rgo.wm.common.utils.validator.rule.ValidationRuleResult;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AbstractValidatorTest {

    private AbstractValidator<Object> validator;

    @Test
    void validate_noRules() {
        List<ValidationRule<Object>> rules = Collections.emptyList();
        validator = new ObjectValidator(rules);
        Object object = new Object();

        ValidationResult result = validator.validate(object);

        assertThat(result.isFailed()).isFalse();
        assertThat(result.getErrorMessage()).isNull();
        assertThat(result.getTotalRules()).isZero();
        assertThat(result.getPassedRules()).isZero();
    }

    @Test
    void validate_rules_passed() {
        List<ValidationRule<Object>> rules = List.of(new ObjectNonNullValidationRule());
        validator = new ObjectValidator(rules);
        Object object = new Object();

        ValidationResult result = validator.validate(object);

        assertThat(result.isFailed()).isFalse();
        assertThat(result.getErrorMessage()).isNull();
        assertThat(result.getTotalRules()).isEqualTo(rules.size());
        assertThat(result.getPassedRules()).isEqualTo(rules.size());
    }

    @Test
    void validate_rules_failed() {
        List<ValidationRule<Object>> rules = List.of(new ObjectNonNullValidationRule());
        validator = new ObjectValidator(rules);

        ValidationResult result = validator.validate(null);

        assertThat(result.isFailed()).isTrue();
        assertThat(result.getErrorMessage()).isEqualTo("The value must not be null.");
        assertThat(result.getTotalRules()).isEqualTo(rules.size());
        assertThat(result.getPassedRules()).isZero();
    }

    private static class ObjectValidator extends AbstractValidator<Object> {

        protected ObjectValidator(List<ValidationRule<Object>> steps) {
            super(steps);
        }

        @Override
        public Class<Object> getType() {
            return Object.class;
        }
    }

    private static class ObjectNonNullValidationRule implements ValidationRule<Object> {

        @Override
        public ValidationRuleResult validate(Object o) {
            if (o == null) {
                return ValidationRuleResult.failed("The value must not be null.");
            }
            return ValidationRuleResult.passed();
        }
    }
}