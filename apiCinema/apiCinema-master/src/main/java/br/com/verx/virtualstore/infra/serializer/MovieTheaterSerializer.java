package br.com.verx.virtualstore.infra.serializer;

import br.com.verx.virtualstore.domain.movie.MovieTheater;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@Component
public class MovieTheaterSerializer extends AbstractSerializer<MovieTheater> {

    @Override
    protected void serialize(final MovieTheater movieTheater, final JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        serializeInformations(movieTheater, jsonWriter);
        jsonWriter.writeEndObject();
    }

    public void serializeInformations(final MovieTheater movieTheater, final JsonWriter jsonWriter)
            throws IOException {
        jsonWriter.writeNumberField(Field.ID, movieTheater.getId());
        jsonWriter.writeStringField(Field.NAME, movieTheater.getName());
        jsonWriter.writeStringField(Field.STREET, movieTheater.getStreet());
        jsonWriter.writeStringField(Field.CITY, movieTheater.getCity());
        jsonWriter.writeStringField(Field.STATE, movieTheater.getState());
    }

    @AllArgsConstructor
    private enum Field {

        CITY("city"),
        ID("id"),
        NAME("name"),
        STATE("state"),
        STREET("street");

        private final String label;

        @Override
        public String toString() {
            return this.label;
        }
    }

}
