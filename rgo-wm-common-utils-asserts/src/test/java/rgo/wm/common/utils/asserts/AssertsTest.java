package rgo.wm.common.utils.asserts;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AssertsTest {

    @Test
    @SuppressWarnings("ConstantConditions")
    void nonNull_exception() {
        Object nullable = null;
        String message = UUID.randomUUID().toString();
        assertThatThrownBy(() -> Asserts.nonNull(nullable, message))
                .isInstanceOf(AssertsException.class)
                .hasMessage(message);
    }

    @Test
    void nonNull() {
        Object obj = new Object();
        String message = UUID.randomUUID().toString();
        Object actual = Asserts.nonNull(obj, message);

        assertThat(actual).isEqualTo(obj);
    }

    @Test
    void nonNegative_exception() {
        int negativeValue = -1;
        String message = UUID.randomUUID().toString();
        assertThatThrownBy(() -> Asserts.nonNegative(negativeValue, message))
                .isInstanceOf(AssertsException.class)
                .hasMessage(message);
    }

    @Test
    void nonNegative() {
        int nonNegativeValue = 0;
        String message = UUID.randomUUID().toString();
        int actual = Asserts.nonNegative(nonNegativeValue, message);
        assertThat(actual).isEqualTo(nonNegativeValue);
    }
}