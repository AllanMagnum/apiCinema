package br.com.verx.virtualstore.infra.serializer;

import br.com.verx.virtualstore.domain.movie.SessionTime;
import java.io.IOException;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@Component
public class SessionTimeSerializer extends AbstractSerializer<SessionTime> {

    @Override
    protected void serialize(final SessionTime sessionTime, final JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        serializeInformation(sessionTime, jsonWriter);
        jsonWriter.writeEndObject();
    }

    public void serializeInformation(final SessionTime sessionTime, final JsonWriter jsonWriter)
            throws IOException {
        jsonWriter.writeNumberField(Field.ID, sessionTime.getId());
        jsonWriter.writeNumberField(Field.SESSION_TIME, sessionTime.getSessionTimeAsTimestamp());
        jsonWriter.writeNumberField(Field.AVAILABLE_ASSENTS, sessionTime.getAvailableAssents());
        jsonWriter.writeNumberField(Field.PRICE, sessionTime.getPrice().setScale(2));
    }

    @AllArgsConstructor
    private enum Field {

        AVAILABLE_ASSENTS("availableAssents"),
        ID("id"),
        SESSION_TIME("sessionTimes"),
        PRICE("price");

        private final String label;

        @Override
        public String toString() {
            return this.label;
        }

    }

}
