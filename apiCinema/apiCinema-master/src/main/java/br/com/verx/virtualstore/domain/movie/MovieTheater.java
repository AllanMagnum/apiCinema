package br.com.verx.virtualstore.domain.movie;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "MOVIE_THEATER", schema = "VTE")
public class MovieTheater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MOVIE_THEATER")
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private final String name;

    @Embedded
    private final Address address;

    @OneToMany(mappedBy = "movieTheater")
    private final List<Session> sessions = new LinkedList<>();

    public MovieTheater(@NotNull final String name, final Address address) {
        this.name = name;
        this.address = address;
    }

    private MovieTheater() {
        this(null, null);
    }

    public List<Session> getSessions() {
        return Collections.unmodifiableList(sessions);
    }

    public String getStreet() {
        return address.getStreet(); //tell dont ask
    }

    public String getCity() {
        return address.getCity(); //tell dont ask
    }

    public String getState() {
        return address.getState(); //tell dont ask
    }

}
