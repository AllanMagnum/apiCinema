package br.com.verx.virtualstore.restapi.wrapper;

import br.com.verx.virtualstore.infra.serializer.ListWrapperSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Collection;
import java.util.Collections;
import lombok.AllArgsConstructor;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@AllArgsConstructor
@JsonSerialize(using = ListWrapperSerializer.class)
public class ListWrapper<E> {

    private final Collection<E> collection;

    public Collection<E> getCollection() {
        return Collections.unmodifiableCollection(collection);
    }
}
