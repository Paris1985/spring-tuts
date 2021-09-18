package rest.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import exceptions.FoundUserException;
import exceptions.UserNotFoundException;

@ControllerAdvice
public class UserControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public void handleNoUserFound() {
        // Nothing to do
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(FoundUserException.class)
    public void handlerFoundUserException() {
        // Nothing to do
    }
}