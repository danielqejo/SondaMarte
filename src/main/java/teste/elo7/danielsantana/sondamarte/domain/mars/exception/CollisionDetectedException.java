package teste.elo7.danielsantana.sondamarte.domain.mars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CollisionDetectedException extends RuntimeException {

    public CollisionDetectedException(String message) {
        super(message);
    }

}
