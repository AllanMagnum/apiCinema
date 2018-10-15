package br.com.verx.virtualstore.domain.movie;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
public interface MovieTheaterReposirtory  extends JpaRepository<MovieTheater, Long> {

    @Query("SELECT DISTINCT m.address.city FROM MovieTheater m")
    List<String> findDistinctByCity();
}
