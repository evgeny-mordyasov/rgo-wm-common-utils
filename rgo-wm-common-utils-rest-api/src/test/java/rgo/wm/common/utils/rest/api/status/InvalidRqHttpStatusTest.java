package rgo.wm.common.utils.rest.api.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InvalidRqHttpStatusTest {

    private InvalidRqHttpStatus status;

    @BeforeEach
    void setUp() {
        status = new InvalidRqHttpStatus();
    }

    @Test
    void getCode() {
        assertThat(status.getCode()).hasToString("INVALID_RQ");
    }
}