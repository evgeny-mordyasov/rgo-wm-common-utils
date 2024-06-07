package rgo.wm.common.utils.rest.api;

import org.junit.jupiter.api.Test;
import rgo.wm.common.utils.asserts.AssertsException;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static rgo.wm.common.test.utils.random.StringRandom.randomString;

class FailureHttpResponseTest {

    private FailureHttpResponse response;

    @Test
    void getStatus() {
        List<ErrorDetail> errorDetails = ErrorDetail.ofAsList(randomString());
        response = new FailureHttpResponse(errorDetails);
        assertThat(response.getStatus()).isEqualTo(HttpResponse.FAILURE_STATUS);
    }

    @Test
    void getErrorDetails_null() {
        assertThatThrownBy(() -> new FailureHttpResponse(null))
                .isInstanceOf(AssertsException.class)
                .hasMessage("'errorDetails' must not be null");
    }

    @Test
    void getErrorDetails_empty() {
        List<ErrorDetail> list = Collections.emptyList();
        assertThatThrownBy(() -> new FailureHttpResponse(list))
                .isInstanceOf(AssertsException.class)
                .hasMessage("'errorDetails' must not be empty");
    }

    @Test
    void getErrorDetails() {
        List<ErrorDetail> errorDetails = ErrorDetail.ofAsList(randomString());
        response = new FailureHttpResponse(errorDetails);
        assertThat(response.errorDetails())
                .isNotNull()
                .isNotEmpty();
    }
}