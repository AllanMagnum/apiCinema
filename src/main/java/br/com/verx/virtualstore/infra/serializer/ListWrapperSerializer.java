package br.com.verx.virtualstore.infra.serializer;

import br.com.verx.virtualstore.restapi.wrapper.ListWrapper;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * Class comments go here...
 *
 * @author José Carlos Mazella Junior
 * @version 1.0 11/10/2018
 */
public class ListWrapperSerializer<E> extends AbstractSerializer<ListWrapper<E>> {

    @Override
    protected void serialize(final ListWrapper<E> listWrapper,
            final JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartArray();
        final Map<Class<?>, AbstractSerializer<?>> serializerMap = getSerializerMap();
        final Collection<E> collection = listWrapper.getCollection();
        for (final E element : collection) {
            final AbstractSerializer abstractSerializer = serializerMap.get(element.getClass());
            abstractSerializer.serialize(element, jsonWriter);
        }
        jsonWriter.writeEndArray();
    }

}
