package br.com.verx.virtualstore.infra.serializer;

import br.com.verx.virtualstore.domain.movie.Movie;
import br.com.verx.virtualstore.domain.movie.MovieTheater;
import br.com.verx.virtualstore.domain.movie.Session;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@Component
@AllArgsConstructor
public class MovieSerializer extends AbstractSerializer<Movie> {

    @Override
    protected void serialize(final Movie movie, final JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        serializInformations(movie, jsonWriter);
        jsonWriter.writeEndObject();
    }

    public void serializInformations(final Movie movie, final JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeNumberField(Field.ID, movie.getId());
        jsonWriter.writeNumberField(Field.CREATION_DATE, movie.getCreationDateAsTimestamp());
        jsonWriter.writeStringField(Field.CATEGORY, movie.getCategory());
        jsonWriter.writeStringField(Field.NAME, movie.getName());
        jsonWriter.writeStringField(Field.SINOPSE, movie.getSinopse());
    }

    @AllArgsConstructor
    private enum Field {

        ID("id"),
        CATEGORY("category"),
        CREATION_DATE("creationDate"),
        NAME("name"),
        SINOPSE("sinopse");

        private final String label;

        @Override
        public String toString() {
            return this.label;
        }
    }

}
