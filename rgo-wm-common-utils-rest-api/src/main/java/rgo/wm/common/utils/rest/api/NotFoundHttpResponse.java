package rgo.wm.common.utils.rest.api;

import rgo.wm.common.utils.asserts.Asserts;
import rgo.wm.common.utils.rest.api.status.HttpStatus;

import java.util.List;

public record NotFoundHttpResponse(List<ErrorDetail> errorDetails) implements HttpResponse {

    public NotFoundHttpResponse(List<ErrorDetail> errorDetails) {
        this.errorDetails = Asserts.nonEmpty(errorDetails, "errorDetails");
    }

    @Override
    public HttpStatus getStatus() {
        return NOT_FOUND_STATUS;
    }
}
