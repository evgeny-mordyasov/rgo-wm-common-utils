package rgo.wm.common.utils.rest.api.status;

public class TooManyRequestsHttpStatus implements HttpStatus {

    @Override
    public String code() {
        return "TOO_MANY_REQUESTS";
    }

    @Override
    public int httpCode() {
        return 429;
    }
}
