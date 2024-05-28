package rgo.wm.common.utils.asserts;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class Asserts {

    private Asserts() {
    }

    @Nonnull
    public static <T> T nonNull(@Nullable T object, String message) {
        if (object == null) {
            throw new AssertsException(message);
        }

        return object;
    }

    public static int nonNegative(int value, String message) {
        if (value < 0) {
            throw new AssertsException(message);
        }

        return value;
    }
}
