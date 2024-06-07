package rgo.wm.common.utils.asserts;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AssertsTest {

    @Test
    @SuppressWarnings("ConstantConditions")
    void nonNull_exception() {
        Object nullable = null;
        String paramName = UUID.randomUUID().toString();
        assertThatThrownBy(() -> Asserts.nonNull(nullable, paramName))
                .isInstanceOf(AssertsException.class)
                .hasMessage("'" + paramName + "' must not be null");
    }

    @Test
    void nonNull() {
        Object obj = new Object();
        String paramName = UUID.randomUUID().toString();
        Object actual = Asserts.nonNull(obj, paramName);

        assertThat(actual).isEqualTo(obj);
    }

    @Test
    void nonNegative_exception() {
        int negativeValue = -1;
        String paramName = UUID.randomUUID().toString();
        assertThatThrownBy(() -> Asserts.nonNegative(negativeValue, paramName))
                .isInstanceOf(AssertsException.class)
                .hasMessage("'" + paramName + "' must not be negative");
    }

    @Test
    void nonNegative() {
        int nonNegativeValue = 0;
        String paramName = UUID.randomUUID().toString();
        int actual = Asserts.nonNegative(nonNegativeValue, paramName);
        assertThat(actual).isEqualTo(nonNegativeValue);
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void nonEmpty_exception_null() {
        List<?> nullable = null;
        String paramName = UUID.randomUUID().toString();
        assertThatThrownBy(() -> Asserts.nonEmpty(nullable, paramName))
                .isInstanceOf(AssertsException.class)
                .hasMessage("'" + paramName + "' must not be null");
    }

    @Test
    void nonEmpty_exception_empty() {
        List<?> nullable = Collections.emptyList();
        String paramName = UUID.randomUUID().toString();
        assertThatThrownBy(() -> Asserts.nonEmpty(nullable, paramName))
                .isInstanceOf(AssertsException.class)
                .hasMessage("'" + paramName + "' must not be empty");
    }

    @Test
    void nonEmpty() {
        List<?> nonEmpty = Collections.singletonList(new Object());
        String paramName = UUID.randomUUID().toString();
        List<?> list = Asserts.nonEmpty(nonEmpty, paramName);
        assertThat(list).isNotNull().isNotEmpty();
    }
}