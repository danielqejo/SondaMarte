package teste.elo7.danielsantana.sondamarte.domain.mars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SpaceProbeAlreadyRegisteredException extends RuntimeException {

    public SpaceProbeAlreadyRegisteredException(String message) {
        super(message);
    }

}
