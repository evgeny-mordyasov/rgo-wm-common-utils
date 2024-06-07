package rgo.wm.common.utils.rest.api;

import rgo.wm.common.utils.asserts.Asserts;
import rgo.wm.common.utils.rest.api.status.HttpStatus;

import java.util.List;

public record InvalidRqHttpResponse(List<ErrorDetail> errorDetails) implements HttpResponse {

    public InvalidRqHttpResponse(List<ErrorDetail> errorDetails) {
        this.errorDetails = Asserts.nonEmpty(errorDetails, "errorDetails");
    }

    @Override
    public HttpStatus getStatus() {
        return INVALID_RQ_STATUS;
    }
}
