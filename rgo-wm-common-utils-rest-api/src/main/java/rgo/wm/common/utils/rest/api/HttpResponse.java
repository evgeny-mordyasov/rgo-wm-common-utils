package rgo.wm.common.utils.rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import rgo.wm.common.utils.rest.api.status.*;

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

    static HttpResponse notFound(List<ErrorDetail> errorDetails) {
        return new NotFoundHttpResponse(errorDetails);
    }

    static HttpResponse tooManyRequests(List<ErrorDetail> errorDetails) {
        return new TooManyRequestsHttpResponse(errorDetails);
    }

    static HttpResponse failure(List<ErrorDetail> errorDetails) {
        return new FailureHttpResponse(errorDetails);
    }
}
