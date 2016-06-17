package pl.agh.arc.exceptions;

/**
 * Created by Arek on 2016-06-17.
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Arek on 2016-05-30.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RestException extends Exception {

    private HttpStatus status;
    private String originalUrl;
    private Object requestBody;

    public RestException(String message, HttpStatus status, String originalUrl) {
        super(message);
        this.status = status;
        this.originalUrl = originalUrl;
    }

    public RestException(String message, HttpStatus status, String originalUrl, Object requestBody) {
        super(message);
        this.status = status;
        this.originalUrl = originalUrl;
        this.requestBody = requestBody;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public Object getRequestBody() {
        return requestBody;
    }
}
