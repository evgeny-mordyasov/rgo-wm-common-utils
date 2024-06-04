package rgo.wm.common.utils.validator.rule;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rgo.wm.common.test.utils.random.StringRandom.randomString;

class StringNonNullValidationRuleTest {

    private final StringNonNullValidationRule rule = new StringNonNullValidationRule();

    @Test
    void validate_passed() {
        String value = randomString();
        ValidationRuleResult result = rule.validate(value);
        assertThat(result.isFailed()).isFalse();
        assertThat(result.getErrorMessage()).isNull();
    }

    @Test
    void validate_failed() {
        ValidationRuleResult result = rule.validate(null);
        assertThat(result.getErrorMessage()).hasToString("The value must not be null.");
    }
}