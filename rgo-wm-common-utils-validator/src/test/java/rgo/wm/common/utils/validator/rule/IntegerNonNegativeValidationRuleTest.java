package rgo.wm.common.utils.validator.rule;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rgo.wm.common.test.utils.random.IntRandom.randomPositiveInt;

class IntegerNonNegativeValidationRuleTest {

    private final IntegerNonNegativeValidationRule rule = new IntegerNonNegativeValidationRule();

    @Test
    void validate_passed() {
        Integer value = randomPositiveInt();
        ValidationRuleResult result = rule.validate(value);
        assertThat(result.isFailed()).isFalse();
        assertThat(result.getErrorMessage()).isNull();
    }

    @Test
    void validate_failed() {
        Integer value = -randomPositiveInt();
        ValidationRuleResult result = rule.validate(value);
        assertThat(result.isFailed()).isTrue();
        assertThat(result.getErrorMessage()).hasToString("The value must not be negative.");
    }
}