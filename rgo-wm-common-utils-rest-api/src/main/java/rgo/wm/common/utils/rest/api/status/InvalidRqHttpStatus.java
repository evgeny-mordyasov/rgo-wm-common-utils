package rgo.wm.common.utils.rest.api.status;

public class InvalidRqHttpStatus implements HttpStatus {

    @Override
    public String getCode() {
        return "INVALID_RQ";
    }
}
