package rgo.wm.common.utils.rest.api.status;

public class CreatedHttpStatus implements HttpStatus {

    @Override
    public String code() {
        return "CREATED";
    }

    @Override
    public int httpCode() {
        return 201;
    }
}
