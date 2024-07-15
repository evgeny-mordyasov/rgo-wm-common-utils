package rgo.wm.common.utils.rest.api.status;

public class InvalidRqHttpStatus implements HttpStatus {

    @Override
    public String code() {
        return "INVALID_RQ";
    }

    @Override
    public int httpCode() {
        return 400;
    }
}
