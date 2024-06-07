package rgo.wm.common.utils.rest.api.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TooManyRequestsHttpStatusTest {

    private TooManyRequestsHttpStatus status;

    @BeforeEach
    void setUp() {
        status = new TooManyRequestsHttpStatus();
    }

    @Test
    void getCode() {
        assertThat(status.getCode()).hasToString("TOO_MANY_REQUESTS");
    }
}