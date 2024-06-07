package rgo.wm.common.utils.asserts;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public final class Asserts {

    private Asserts() {
    }

    @Nonnull
    public static <T> T nonNull(@Nullable T object, String paramName) {
        if (object == null) {
            throw new AssertsException("'" + paramName + "' must not be null");
        }
        return object;
    }

    public static int nonNegative(int value, String paramName) {
        if (value < 0) {
            throw new AssertsException("'" + paramName + "' must not be negative");
        }
        return value;
    }

    @Nonnull
    public static <T> List<T> nonEmpty(@Nullable List<T> list, String paramName) {
        if (nonNull(list, paramName).isEmpty()) {
            throw new AssertsException("'" + paramName + "' must not be empty");
        }
        return list;
    }
}
