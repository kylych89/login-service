package us.peaksoft.loginservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class IncorrectPassword extends RuntimeException{
    public IncorrectPassword(String message) {
        super(message);
    }
}
