package rgo.wm.common.utils.rest.api.status;

public class SuccessfulHttpStatus implements HttpStatus {

    @Override
    public String code() {
        return "SUCCESS";
    }

    @Override
    public int httpCode() {
        return 200;
    }
}
