package rgo.wm.common.utils.asserts;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

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

    public static <T> Collection<T> nonEmpty(Collection<T> collection, String message) {
        if (collection.isEmpty()) {
            throw new AssertsException(message);
        }
        return collection;
    }
}
