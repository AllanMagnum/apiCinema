package br.com.verx.virtualstore.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
public interface SessionRepository extends JpaRepository<Session, Long> {

    Session findByMovieIdAndMovieTheaterId(final Long idMovide, final Long idMovieTheater);

    Session findByMovieIdAndMovieTheaterIdAndSessionTimesId(Long idMovide, Long idMovieTheater, Long idSessionTimes);

}
