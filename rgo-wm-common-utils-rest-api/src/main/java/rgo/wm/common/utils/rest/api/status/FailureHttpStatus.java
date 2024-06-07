package rgo.wm.common.utils.rest.api.status;

public class FailureHttpStatus implements HttpStatus {

    @Override
    public String getCode() {
        return "FAILURE";
    }
}
