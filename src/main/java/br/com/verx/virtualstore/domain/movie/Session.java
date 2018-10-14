package br.com.verx.virtualstore.domain.movie;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@Getter
@Entity
@Table(name = "SESSION", schema = "VTE")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SESSION")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_MOVIE")
    private final Movie movie;

    @ManyToOne
    @JoinColumn(name = "ID_MOVIE_THEATER")
    private final MovieTheater movieTheater;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private final List<SessionTime> sessionTimes = new LinkedList<>();

    public Session(final Movie movie, final MovieTheater movieTheater, final List<SessionTime> sessionTimes) {
        this.movie = movie;
        this.movieTheater = movieTheater;
        this.sessionTimes.addAll(sessionTimes);
    }

    private Session() {
        this(null, null, new LinkedList<>());
    }

    public List<SessionTime> getSessionTimes() {
        return Collections.unmodifiableList(sessionTimes);
    }

}

