package br.com.verx.virtualstore.application;

import br.com.verx.virtualstore.domain.movie.Movie;
import br.com.verx.virtualstore.domain.movie.MovieTheater;
import br.com.verx.virtualstore.domain.movie.Session;
import br.com.verx.virtualstore.domain.movie.SessionService;
import br.com.verx.virtualstore.domain.movie.SessionTime;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@ApplicationService
@AllArgsConstructor
public class SessionApplicationService {

    private final SessionService sessionService;

    public Integer getAvailableAssents(final Long idMovide, final Long idMovieTheater,
            final Long idSessionTimes) {
        return sessionService.getAvailableAssents(idMovide, idMovieTheater, idSessionTimes);
    }

    public List<MovieTheater> getMovieTheaterByMovie(final Long idMovie) {
        return sessionService.getMovieTheaterByMovie(idMovie);
    }

    public List<Movie> getMoviesByCity(final String city) {
        return sessionService.getMoviesByCity(city);
    }

    public Session getSessionById(final Long id) {
        return sessionService.getSessionById(id);
    }

    public List<SessionTime> getSessionTimesForTheaterMovie(final Long idMovide, final Long idMovieTheater) {
        return sessionService.getSessionTimesForTheaterMovieAndMovie(idMovide, idMovieTheater);
    }

    public List<Session> getSessions() {
        return sessionService.getSessions();
    }

    public List<String> getCitiesOfSessions() {
        return sessionService.getCitiesOfSessions();
    }

    public BigDecimal subTotalAvailableAssents(final Long idMovide, final Long idMovieTheater,
            final Long idSessionTimes, final Integer amountAssents) {
        return sessionService
                .subTotalAvailableAssents(idMovide, idMovieTheater, idSessionTimes, amountAssents);
    }
}
