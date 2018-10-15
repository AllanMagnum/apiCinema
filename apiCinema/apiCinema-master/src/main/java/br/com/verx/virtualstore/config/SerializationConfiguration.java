package br.com.verx.virtualstore.config;

import br.com.verx.virtualstore.domain.movie.Movie;
import br.com.verx.virtualstore.domain.movie.MovieTheater;
import br.com.verx.virtualstore.domain.movie.Session;
import br.com.verx.virtualstore.domain.movie.SessionTime;
import br.com.verx.virtualstore.infra.serializer.AbstractSerializer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@Configuration
public class SerializationConfiguration {

    @Bean
    public Map<Class<?>, AbstractSerializer<?>> beanSerializerMap(
            @Qualifier("movieSerializer") final AbstractSerializer movieSerializer,
            @Qualifier("movieTheaterSerializer") final AbstractSerializer movieTheaterSerializer,
            @Qualifier("sessionSerializer") final AbstractSerializer sessionSerializer,
            @Qualifier("sessionTimeSerializer") final AbstractSerializer sessionTimeSerializer) {
        final Map<Class<?>, AbstractSerializer<?>> serializerMap = new HashMap<>();
        serializerMap.put(Movie.class, movieSerializer);
        serializerMap.put(MovieTheater.class, movieTheaterSerializer);
        serializerMap.put(Session.class, sessionSerializer);
        serializerMap.put(SessionTime.class, sessionTimeSerializer);
        return Collections.unmodifiableMap(serializerMap);
    }

}
