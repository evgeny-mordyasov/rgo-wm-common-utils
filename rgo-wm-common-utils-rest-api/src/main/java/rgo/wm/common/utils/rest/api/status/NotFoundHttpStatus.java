package rgo.wm.common.utils.rest.api.status;

public class NotFoundHttpStatus implements HttpStatus {

    @Override
    public String code() {
        return "NOT_FOUND";
    }

    @Override
    public int httpCode() {
        return 404;
    }
}
