package rgo.wm.common.utils.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static rgo.wm.common.test.utils.random.StringRandom.randomString;

class ValidationEngineTest {

    private ValidationEngine engine;
    private final ValidatorRegistry registry = mock(ValidatorRegistry.class);
    private final Validator<Object> validator = mock(Validator.class);

    @Test
    void validate_passed() {
        ValidationResult result = ValidationResult.passed(1);
        when(validator.validate(any())).thenReturn(result);
        when(registry.getValidator(any())).thenReturn(validator);
        engine = new ValidationEngine(registry);

        Object o = new Object();
        String parameterName = randomString();

        assertThatNoException().isThrownBy(() -> engine.validate(o, parameterName));
    }

    @Test
    void validate_failed() {
        ValidationResult result = ValidationResult.failed(1, 0, randomString());
        when(validator.validate(any())).thenReturn(result);
        when(registry.getValidator(any())).thenReturn(validator);
        engine = new ValidationEngine(registry);

        Object o = new Object();
        String parameterName = randomString();

        assertThatThrownBy(() -> engine.validate(o, parameterName))
                .isInstanceOf(ValidationException.class);
    }
}