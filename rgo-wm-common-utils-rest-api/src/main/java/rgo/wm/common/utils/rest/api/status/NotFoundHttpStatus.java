package rgo.wm.common.utils.rest.api.status;

public class NotFoundHttpStatus implements HttpStatus {

    @Override
    public String getCode() {
        return "NOT_FOUND";
    }
}
