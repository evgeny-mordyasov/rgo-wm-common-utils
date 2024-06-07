package rgo.wm.common.utils.validator;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static rgo.wm.common.test.utils.random.StringRandom.randomString;

class ConstraintViolationsTest {

    @Test
    void messages_empty() {
        List<String> messages = ConstraintViolations.messages(Collections.emptySet());
        assertThat(messages).isEmpty();
    }

    @Test
    void messages() {
        ConstraintViolation<?> violation = mock(ConstraintViolation.class);
        String message = randomString();
        when(violation.getMessage()).thenReturn(message);

        List<String> messages = ConstraintViolations.messages(Set.of(violation));

        assertThat(messages)
                .isNotEmpty()
                .contains(message);
    }
}