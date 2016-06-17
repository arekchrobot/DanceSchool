package pl.agh.arc.util;

/**
 * Created by Arek on 2016-06-17.
 */
public class ExceptionWrapper {

    private int status;
    private String message;

    public ExceptionWrapper(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Status=" + status + ", Message=" + message;
    }
}
