package br.com.verx.virtualstore.infra.serializer;

import br.com.verx.virtualstore.domain.movie.Movie;
import br.com.verx.virtualstore.domain.movie.MovieTheater;
import br.com.verx.virtualstore.domain.movie.Session;
import br.com.verx.virtualstore.domain.movie.SessionTime;
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
public class SessionSerializer extends AbstractSerializer<Session> {

    private final MovieSerializer movieSerializer;
    private final MovieTheaterSerializer movieTheaterSerializer;
    private final SessionTimeSerializer sessionTimeSerializer;

    @Override
    protected void serialize(final Session session, final JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeNumberField(Field.ID, session.getId());
        serializeMovieInformations(session.getMovie(), jsonWriter);
        serializeMovieTheaterInformations(session.getMovieTheater(), jsonWriter);
        serializeSesssionTimeInformations(session.getSessionTimes(), jsonWriter);
        jsonWriter.writeEndObject();
    }

    private void serializeSesssionTimeInformations(final List<SessionTime> sessionTimes,
            final JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeArrayFieldStart(Field.SESSION_TIMES);
        for (final SessionTime sessionTime : sessionTimes) {
            jsonWriter.writeStartObject();
            sessionTimeSerializer.serializeInformation(sessionTime, jsonWriter);
            jsonWriter.writeEndObject();
        }
        jsonWriter.writeEndArray();
    }

    private void serializeMovieInformations(final Movie movie, final JsonWriter jsonWriter)
            throws IOException {
        jsonWriter.writeObjectFieldStart(Field.MOVIE);
        movieSerializer.serializInformations(movie, jsonWriter);
        jsonWriter.writeEndObject();
    }

    private void serializeMovieTheaterInformations(final MovieTheater movieTheater,
            final JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeObjectFieldStart(Field.MOVIE_THEATER);
        movieTheaterSerializer.serializeInformations(movieTheater, jsonWriter);
        jsonWriter.writeEndObject();
    }

    @AllArgsConstructor
    private enum Field {

        ID("id"),
        MOVIE("movie"),
        MOVIE_THEATER("movieTheater"),
        SESSION_TIMES("sessionTimes");

        private final String label;

        @Override
        public String toString() {
            return this.label;
        }

    }

}
