package rgo.wm.common.utils.rest.api.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SuccessfulHttpStatusTest {

    private SuccessfulHttpStatus status;

    @BeforeEach
    void setUp() {
        status = new SuccessfulHttpStatus();
    }

    @Test
    void getCode() {
        assertThat(status.getCode()).hasToString("SUCCESS");
    }
}