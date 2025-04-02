package rgo.wm.common.utils.validator.rest;

import jakarta.annotation.Nonnull;
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

    @Nonnull
    public <T> HttpResponse validate(@Nonnull T rq, @Nonnull Supplier<HttpResponse> supplier) {
        List<String> errorMessages = validator.validate(rq);
        if (errorMessages.isEmpty()) {
            return supplier.get();
        }

        return HttpResponse.invalidRq(ErrorDetail.of(errorMessages));
    }
}
