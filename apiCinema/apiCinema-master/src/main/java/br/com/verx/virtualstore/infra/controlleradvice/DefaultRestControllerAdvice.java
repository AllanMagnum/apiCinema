package br.com.verx.virtualstore.infra.controlleradvice;

import br.com.verx.virtualstore.infra.exception.ApplicationException;
import br.com.verx.virtualstore.infra.exception.ErrorData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@RestControllerAdvice(basePackages = {"br.com.verx.virtualstore.restapi"})
public class DefaultRestControllerAdvice {

    private final Logger logger  = LoggerFactory.getLogger(getClass());

    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity handleApplicationException(final ApplicationException applicationException) {
        logger.error(applicationException.getMessage(), applicationException);
        final ResponseStatus annotation = applicationException.getClass().getAnnotation(ResponseStatus.class);
        final ErrorData errorData = new ErrorData(annotation.code().value(), applicationException.getMessage());
        return new ResponseEntity<>(errorData, annotation.code());
    }

}
