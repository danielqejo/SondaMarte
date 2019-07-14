package teste.elo7.danielsantana.sondamarte.domain.mars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BoundaryViolationException extends RuntimeException {

    public BoundaryViolationException(String message) {
        super(message);
    }

}
