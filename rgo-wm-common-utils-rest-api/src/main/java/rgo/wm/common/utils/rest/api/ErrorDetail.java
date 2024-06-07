package rgo.wm.common.utils.rest.api;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ErrorDetail {

    private final String message;

    private ErrorDetail(String message) {
        this.message = message;
    }

    public static ErrorDetail of(String message) {
        return new ErrorDetail(message);
    }

    public static List<ErrorDetail> ofAsList(String message) {
        return Collections.singletonList(of(message));
    }

    public static List<ErrorDetail> of(List<String> messages) {
        return messages.stream()
                .map(ErrorDetail::of)
                .toList();
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDetail that = (ErrorDetail) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
