package us.peaksoft.loginservice.exceptions;

/**
 * Created by Sayfullah on 12.03.2021.
 */
public class UserIsNotActive extends RuntimeException{
    public UserIsNotActive(String message) {
        super(message);
    }
}
