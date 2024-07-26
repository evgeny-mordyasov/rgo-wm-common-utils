package rgo.wm.common.utils.rest.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NotFoundHttpResponseTest {

    @Test
    void getStatus() {
        NotFoundHttpResponse response = new NotFoundHttpResponse();
        assertThat(response.status()).isEqualTo(HttpResponse.NOT_FOUND_STATUS);
    }
}