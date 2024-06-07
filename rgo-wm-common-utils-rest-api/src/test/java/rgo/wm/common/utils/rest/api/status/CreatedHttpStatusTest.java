package rgo.wm.common.utils.rest.api.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreatedHttpStatusTest {

    private CreatedHttpStatus status;

    @BeforeEach
    void setUp() {
        status = new CreatedHttpStatus();
    }

    @Test
    void getCode() {
        assertThat(status.getCode()).hasToString("CREATED");
    }
}