package br.com.verx.virtualstore.restapi.wrapper;

import br.com.verx.virtualstore.domain.movie.Session;
import br.com.verx.virtualstore.infra.serializer.SessionWrapperSerializer;
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
@JsonSerialize(using = SessionWrapperSerializer.class)
public class SessionWrapper {

    private final Session session;

}
