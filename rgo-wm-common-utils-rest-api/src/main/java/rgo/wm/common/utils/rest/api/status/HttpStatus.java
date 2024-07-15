package rgo.wm.common.utils.rest.api.status;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface HttpStatus {

    @JsonProperty("code")
    String code();

    int httpCode();
}
