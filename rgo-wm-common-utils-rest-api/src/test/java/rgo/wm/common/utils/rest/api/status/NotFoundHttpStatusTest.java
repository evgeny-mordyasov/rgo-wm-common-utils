package rgo.wm.common.utils.rest.api.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NotFoundHttpStatusTest {

    private NotFoundHttpStatus status;

    @BeforeEach
    void setUp() {
        status = new NotFoundHttpStatus();
    }

    @Test
    void getCode() {
        assertThat(status.getCode()).hasToString("NOT_FOUND");
    }
}