package rgo.wm.common.utils.validator.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rgo.wm.common.utils.rest.api.HttpResponse;
import rgo.wm.common.utils.rest.api.InvalidRqHttpResponse;
import rgo.wm.common.utils.validator.ValidatorAdapter;

import java.util.Collections;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static rgo.wm.common.test.utils.random.StringRandom.randomString;

class RestValidatorAdapterTest {

    private RestValidatorAdapter restValidatorAdapter;
    private ValidatorAdapter validatorAdapter;

    @BeforeEach
    void setUp() {
        validatorAdapter = mock(ValidatorAdapter.class);
        restValidatorAdapter = new RestValidatorAdapter(validatorAdapter);
    }

    @Test
    void validate_noErrors() {
        Object rq = new Object();
        HttpResponse expected = HttpResponse.notFound();
        Supplier<HttpResponse> supplier = () -> expected;
        when(validatorAdapter.validate(rq)).thenReturn(Collections.emptyList());

        HttpResponse actual = restValidatorAdapter.validate(rq, supplier);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void validate_errorsExists() {
        Object rq = new Object();
        HttpResponse nonExpected = HttpResponse.notFound();
        Supplier<HttpResponse> supplier = () -> nonExpected;
        String errorMessage = randomString();
        when(validatorAdapter.validate(rq)).thenReturn(Collections.singletonList(errorMessage));

        HttpResponse actual = restValidatorAdapter.validate(rq, supplier);

        assertThat(actual).isNotEqualTo(nonExpected);
        assertThat(actual.status().code()).isEqualTo("INVALID_RQ");
        assertThat(actual.status().httpCode()).isEqualTo(400);
        assertInstanceOf(InvalidRqHttpResponse.class, actual);
        assertThat(((InvalidRqHttpResponse) actual).errorDetails()).hasSize(1);
        assertThat(((InvalidRqHttpResponse) actual).errorDetails().get(0).getMessage()).contains(errorMessage);
    }
}