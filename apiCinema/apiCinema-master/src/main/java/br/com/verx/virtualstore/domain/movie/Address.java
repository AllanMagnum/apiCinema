package br.com.verx.virtualstore.domain.movie;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import lombok.Getter;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@Embeddable
@Getter
public class Address {

    @NotNull
    @Column(name = "STREET")
    private final String street;

    @Column(name = "CITY")
    private final String city;

    @Column(name = "STATE")
    private final String state;

    public Address(final String street, final String city, final String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    private Address() {
        this(null, null, null);
    }

}
