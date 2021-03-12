package us.peaksoft.loginservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SessionNotFound extends RuntimeException{
    public SessionNotFound(String message) {
        super(message);
    }
}
