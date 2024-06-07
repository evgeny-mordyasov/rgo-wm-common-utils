package rgo.wm.common.utils.rest.api.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FailureHttpStatusTest {

    private FailureHttpStatus status;

    @BeforeEach
    void setUp() {
        status = new FailureHttpStatus();
    }

    @Test
    void getCode() {
        assertThat(status.getCode()).hasToString("FAILURE");
    }
}