package rgo.wm.common.utils.rest.api;

import rgo.wm.common.utils.rest.api.status.HttpStatus;

public record TooManyRequestsHttpResponse() implements HttpResponse {

    @Override
    public HttpStatus status() {
        return TOO_MANY_REQUESTS_STATUS;
    }
}
