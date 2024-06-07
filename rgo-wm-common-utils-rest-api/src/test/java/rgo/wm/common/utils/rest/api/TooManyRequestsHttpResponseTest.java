package rgo.wm.common.utils.rest.api;

import org.junit.jupiter.api.Test;
import rgo.wm.common.utils.asserts.AssertsException;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static rgo.wm.common.test.utils.random.StringRandom.randomString;

class TooManyRequestsHttpResponseTest {

    private TooManyRequestsHttpResponse response;

    @Test
    void getStatus() {
        List<ErrorDetail> errorDetails = ErrorDetail.ofAsList(randomString());
        response = new TooManyRequestsHttpResponse(errorDetails);
        assertThat(response.getStatus()).isEqualTo(HttpResponse.TOO_MANY_REQUESTS_STATUS);
    }

    @Test
    void getErrorDetails_null() {
        assertThatThrownBy(() -> new TooManyRequestsHttpResponse(null))
                .isInstanceOf(AssertsException.class)
                .hasMessage("'errorDetails' must not be null");
    }

    @Test
    void getErrorDetails_empty() {
        List<ErrorDetail> list = Collections.emptyList();
        assertThatThrownBy(() -> new TooManyRequestsHttpResponse(list))
                .isInstanceOf(AssertsException.class)
                .hasMessage("'errorDetails' must not be empty");
    }

    @Test
    void getErrorDetails() {
        List<ErrorDetail> errorDetails = ErrorDetail.ofAsList(randomString());
        response = new TooManyRequestsHttpResponse(errorDetails);
        assertThat(response.errorDetails())
                .isNotNull()
                .isNotEmpty();
    }
}