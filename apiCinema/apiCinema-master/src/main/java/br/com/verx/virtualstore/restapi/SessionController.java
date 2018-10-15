package br.com.verx.virtualstore.restapi;

import br.com.verx.virtualstore.application.SessionApplicationService;
import br.com.verx.virtualstore.restapi.wrapper.ListWrapper;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@RestController
@AllArgsConstructor
public class SessionController {

    private final SessionApplicationService sessionApplicationService;

    @GetMapping("/sessions/cities")
    public List<String> getCitiesOfSessions() {
        return sessionApplicationService.getCitiesOfSessions();
    }

    @GetMapping("/sessions/movies")
    public ListWrapper getMoviesByCity(@RequestParam("city") final String city) {
        return new ListWrapper<>(sessionApplicationService.getMoviesByCity(city));
    }

    @GetMapping("/sessions/movies-theaters")
    public ListWrapper getMovieTheaterByMovie(@RequestParam("movie") final Long idMovie) {
        return new ListWrapper<>(sessionApplicationService.getMovieTheaterByMovie(idMovie));
    }

    @GetMapping("/sessions/session-times")
    public ListWrapper getSessionTimesForTheaterMovie(@RequestParam("movie") final Long idMovide,
            @RequestParam("movie-theater") final Long idMovieTheater) {
        return new ListWrapper<>(
                sessionApplicationService.getSessionTimesForTheaterMovie(idMovide, idMovieTheater));
    }

    @GetMapping("/sessions/available-assents")
    public Integer getAvailablesAssents(@RequestParam("movie") final Long idMovide,
            @RequestParam("movie-theater") final Long idMovieTheater,
            @RequestParam("session-time") final Long idSessionTimes) {
        return sessionApplicationService.getAvailableAssents(idMovide, idMovieTheater, idSessionTimes);
    }

    @GetMapping("/sessions/available-assents/subtotal")
    public BigDecimal subTotalAvailablesAssents(@RequestParam("movie") final Long idMovide,
            @RequestParam("movie-theater") final Long idMovieTheater,
            @RequestParam("session-time") final Long idSessionTimes,
            @RequestParam("amount-assents") final Integer amountAssents) {
        return sessionApplicationService
                .subTotalAvailableAssents(idMovide, idMovieTheater, idSessionTimes, amountAssents);
    }

}