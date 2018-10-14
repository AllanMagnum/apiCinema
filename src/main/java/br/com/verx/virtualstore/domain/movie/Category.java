package br.com.verx.virtualstore.domain.movie;

import lombok.AllArgsConstructor;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@AllArgsConstructor
public enum Category {

    CARTOON("Cartoon"),
    SUSPENSE("Suspense"),
    ROMANTIC("Romantic");

    private final String category;

    @Override
    public String toString() {
        return this.category;
    }

}
