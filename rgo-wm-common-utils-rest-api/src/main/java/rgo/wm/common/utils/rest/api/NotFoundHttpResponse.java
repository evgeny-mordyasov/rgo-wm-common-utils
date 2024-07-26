package rgo.wm.common.utils.rest.api;

import rgo.wm.common.utils.rest.api.status.HttpStatus;

public record NotFoundHttpResponse() implements HttpResponse {

    @Override
    public HttpStatus status() {
        return NOT_FOUND_STATUS;
    }
}
