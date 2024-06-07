package rgo.wm.common.utils.rest.api.status;

public class TooManyRequestsHttpStatus implements HttpStatus {

    @Override
    public String getCode() {
        return "TOO_MANY_REQUESTS";
    }
}
