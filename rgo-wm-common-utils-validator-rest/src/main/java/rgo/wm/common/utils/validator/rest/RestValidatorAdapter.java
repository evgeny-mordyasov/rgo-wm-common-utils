package rgo.wm.common.utils.validator.rest;

import rgo.wm.common.utils.rest.api.ErrorDetail;
import rgo.wm.common.utils.rest.api.HttpResponse;
import rgo.wm.common.utils.validator.ValidatorAdapter;

import java.util.List;
import java.util.function.Supplier;

public class RestValidatorAdapter {

    private final ValidatorAdapter validator;

    public RestValidatorAdapter(ValidatorAdapter validator) {
        this.validator = validator;
    }

    public <T> HttpResponse validate(T rq, Supplier<HttpResponse> supplier) {
        List<String> errorMessages = validator.validate(rq);
        if (errorMessages.isEmpty()) {
            return supplier.get();
        }

        return HttpResponse.invalidRq(ErrorDetail.of(errorMessages));
    }
}
