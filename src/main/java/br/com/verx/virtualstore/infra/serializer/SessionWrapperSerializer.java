package br.com.verx.virtualstore.infra.serializer;

import br.com.verx.virtualstore.domain.movie.Session;
import br.com.verx.virtualstore.infra.util.ApplicationContextHolder;
import br.com.verx.virtualstore.restapi.wrapper.SessionWrapper;
import java.io.IOException;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
public class SessionWrapperSerializer extends AbstractSerializer<SessionWrapper> {

    final AbstractSerializer sessionSerializer = ApplicationContextHolder.getBean(SessionSerializer.class);

    @Override
    protected void serialize(final SessionWrapper sessionWrapper, final JsonWriter jsonWriter) throws IOException {
        sessionSerializer.serialize(sessionWrapper.getSession(), jsonWriter);
    }

}
