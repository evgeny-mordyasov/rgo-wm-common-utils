package rgo.wm.common.utils.rest.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TooManyRequestsHttpResponseTest {

    @Test
    void getStatus() {
        TooManyRequestsHttpResponse response = new TooManyRequestsHttpResponse();
        assertThat(response.status()).isEqualTo(HttpResponse.TOO_MANY_REQUESTS_STATUS);
    }
}