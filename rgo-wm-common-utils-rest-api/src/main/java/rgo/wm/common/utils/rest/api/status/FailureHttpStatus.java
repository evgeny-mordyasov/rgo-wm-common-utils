package rgo.wm.common.utils.rest.api.status;

public class FailureHttpStatus implements HttpStatus {

    @Override
    public String code() {
        return "FAILURE";
    }

    @Override
    public int httpCode() {
        return 500;
    }
}
