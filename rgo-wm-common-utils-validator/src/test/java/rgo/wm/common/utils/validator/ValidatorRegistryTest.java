package rgo.wm.common.utils.validator;

import org.junit.jupiter.api.Test;
import rgo.wm.common.utils.asserts.AssertsException;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

class ValidatorRegistryTest {

    private ValidatorRegistry registry;

    @Test
    void create_validatorsIsEmpty() {
        List<Validator<?>> validators = Collections.emptyList();
        assertThatThrownBy(() -> new ValidatorRegistry(validators))
                .isInstanceOf(AssertsException.class)
                .hasMessage("'validators' must not be empty");
    }

    @Test
    void getValidator() {
        Validator<?> expectedValidator = mock(Validator.class);
        List<Validator<?>> validators = List.of(expectedValidator);
        registry = new ValidatorRegistry(validators);

        Validator<?> actualValidator = registry.getValidator(expectedValidator.getType());

        assertThat(actualValidator).isEqualTo(expectedValidator);
    }

    @Test
    void getValidator_unknownValidator() {
        Validator<?> validator = mock(Validator.class);
        List<Validator<?>> validators = List.of(validator);
        registry = new ValidatorRegistry(validators);

        Object object = new Object();
        Class<Object> fakeType = Object.class;
        Validator<Object> actualValidator = registry.getValidator(fakeType);

        assertThatThrownBy(() -> actualValidator.validate(object))
                .isInstanceOf(UnknownValidator.UnknownValidatorException.class)
                .hasMessage("The " + fakeType + " is not registered in the validator registry.");
    }
}