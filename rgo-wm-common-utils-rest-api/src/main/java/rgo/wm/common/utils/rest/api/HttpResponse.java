package rgo.wm.common.utils.rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import rgo.wm.common.utils.rest.api.status.CreatedHttpStatus;
import rgo.wm.common.utils.rest.api.status.FailureHttpStatus;
import rgo.wm.common.utils.rest.api.status.HttpStatus;
import rgo.wm.common.utils.rest.api.status.InvalidRqHttpStatus;
import rgo.wm.common.utils.rest.api.status.NotFoundHttpStatus;
import rgo.wm.common.utils.rest.api.status.SuccessfulHttpStatus;
import rgo.wm.common.utils.rest.api.status.TooManyRequestsHttpStatus;

import java.util.List;

public interface HttpResponse {

    HttpStatus SUCCESSFUL_STATUS = new SuccessfulHttpStatus();
    HttpStatus CREATED_STATUS = new CreatedHttpStatus();
    HttpStatus INVALID_RQ_STATUS = new InvalidRqHttpStatus();
    HttpStatus NOT_FOUND_STATUS = new NotFoundHttpStatus();
    HttpStatus TOO_MANY_REQUESTS_STATUS = new TooManyRequestsHttpStatus();
    HttpStatus FAILURE_STATUS = new FailureHttpStatus();

    @JsonProperty("status")
    HttpStatus status();

    static HttpResponse invalidRq(List<ErrorDetail> errorDetails) {
        return new InvalidRqHttpResponse(errorDetails);
    }

    static HttpResponse notFound() {
        return new NotFoundHttpResponse();
    }

    static HttpResponse tooManyRequests() {
        return new TooManyRequestsHttpResponse();
    }

    static HttpResponse failure(List<ErrorDetail> errorDetails) {
        return new FailureHttpResponse(errorDetails);
    }
}
