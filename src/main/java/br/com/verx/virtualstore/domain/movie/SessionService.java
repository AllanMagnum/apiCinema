package br.com.verx.virtualstore.domain.movie;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@Service
@AllArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;
    private final MovieTheaterReposirtory movieTheaterReposirtory;

    public void buyAvailableAssents() {

    }

    public Integer getAvailableAssents(final Long idMovide, final Long idMovieTheater,
            final Long idSessionTimes) {
        final Session session = sessionRepository
                .findByMovieIdAndMovieTheaterIdAndSessionTimesId(idMovide, idMovieTheater, idSessionTimes);
        final SessionTime sessionTime = session.getSessionTimes().stream()
                .filter(s -> s.getId().equals(idSessionTimes)).findFirst().get();
        return sessionTime.getAvailableAssents();
    }

    public List<MovieTheater> getMovieTheaterByMovie(final Long idMovie) {
        final List<MovieTheater> collect = sessionRepository.findAll().stream()
                .filter(session -> session.getMovie().getId().equals(idMovie)).map(Session::getMovieTheater)
                .collect(Collectors.toList());
        return collect;
    }

    public List<SessionTime> getSessionTimesForTheaterMovieAndMovie(final Long idMovide,
            final Long idMovieTheater) {
        final Session session = sessionRepository.findByMovieIdAndMovieTheaterId(idMovide, idMovieTheater);
        return session.getSessionTimes();
    }

    public List<Session> getSessions() {
        final List<Session> sessions = sessionRepository.findAll();
        if (!CollectionUtils.isEmpty(sessions)) {
            return Collections.unmodifiableList(sessions);
        }
        throw new SessionNotFoundException("No records found");
    }

    public Session getSessionById(final Long id) {
        final Optional<Session> session = sessionRepository.findById(id);
        if (session.isPresent()) {
            return session.get();
        }
        throw new SessionNotFoundException(String.format("Session with id '%s' not found", id));
    }

    public List<String> getCitiesOfSessions() {
        return movieTheaterReposirtory.findDistinctByCity();
    }

    public List<Movie> getMoviesByCity(final String city) {
        final List<Movie> collect = sessionRepository.findAll().stream()
                .filter(session -> session.getMovieTheater().getCity().equals(city)).map(Session::getMovie)
                .collect(Collectors.toList());
        return collect;
    }

    public BigDecimal subTotalAvailableAssents(final Long idMovide, final Long idMovieTheater,
            final Long idSessionTimes, final Integer amountAssents) {
        final Session session = sessionRepository
                .findByMovieIdAndMovieTheaterIdAndSessionTimesId(idMovide, idMovieTheater, idSessionTimes);
        final SessionTime sessionTime = session.getSessionTimes().stream()
                .filter(s -> s.getId().equals(idSessionTimes)).findFirst().get();
        return sessionTime.getSubTotal(amountAssents);
    }
}
