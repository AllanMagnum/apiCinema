package br.com.verx.virtualstore.domain.movie;

import br.com.verx.virtualstore.infra.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SessionNotFoundException extends ApplicationException {

    public SessionNotFoundException(final String message) {
        super(message);
    }

}
