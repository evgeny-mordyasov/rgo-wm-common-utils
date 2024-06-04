package rgo.wm.common.utils.validator.rule;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rgo.wm.common.test.utils.random.StringRandom.randomString;

class StringNonEmptyValidationRuleTest {

    private final StringNonEmptyValidationRule rule = new StringNonEmptyValidationRule();

    @Test
    void validate_passed() {
        String value = randomString();
        ValidationRuleResult result = rule.validate(value);
        assertThat(result.isFailed()).isFalse();
        assertThat(result.getErrorMessage()).isNull();
    }

    @Test
    void validate_failed() {
        String value = "";
        ValidationRuleResult result = rule.validate(value);
        assertThat(result.isFailed()).isTrue();
        assertThat(result.getErrorMessage()).hasToString("The value must not be empty.");
    }
}