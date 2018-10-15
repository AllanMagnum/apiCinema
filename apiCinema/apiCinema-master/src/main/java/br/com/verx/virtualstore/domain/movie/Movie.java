package br.com.verx.virtualstore.domain.movie;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "MOVIE", schema = "VTE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MOVIE")
    private Long id;

    @NotNull
    @Column(name = "CREATION_DATE")
    private final LocalDateTime creationDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY")
    private final Category category;

    @NotNull
    @Column(name = "NAME")
    private final String name;

    @NotNull
    @Column(name = "SINOPSE")
    private final String sinopse;

    @OneToMany(mappedBy = "movie")
    private final List<Session> sessions = new LinkedList<>();

    public Movie(@NotNull final Category category, @NotNull final String name,
            @NotNull final String sinopse) {
        this.creationDate = LocalDateTime.now();
        this.category = category;
        this.name = name;
        this.sinopse = sinopse;
    }

    private Movie() {
        this(null, null, null);
    }

    public List<Session> getSessions() {
        return Collections.unmodifiableList(sessions);
    }

    public Long getCreationDateAsTimestamp() {
        return creationDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

}
