package br.com.verx.virtualstore.infra.exception;

import br.com.verx.virtualstore.infra.serializer.ErrorDataSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@AllArgsConstructor
@Getter
@JsonSerialize(using = ErrorDataSerializer.class)
public class ErrorData {

    private final Integer code;
    private final String message;

}
