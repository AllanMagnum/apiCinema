package br.com.verx.virtualstore.infra.serializer;

import br.com.verx.virtualstore.infra.util.ApplicationContextHolder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Map;

/**
 * An abstract class to help with serialization objects
 *
 * @author Allan Magnum
 * @version 1.0 08/10/2018
 */
public abstract class AbstractSerializer<T> extends JsonSerializer<T> {

    protected abstract void serialize(final T value, final JsonWriter jsonWriter) throws IOException;

    @Override
    public void serialize(final T value, final JsonGenerator jsonGenerator, final SerializerProvider serializers) throws IOException {
        final JsonWriter jsonWriter = new JsonWriter(jsonGenerator);
        serialize(value, new JsonWriter(jsonGenerator));
    }

    /**
     * This methos return a map values that will be
     *
     * @return map of class and serializers
     */
    protected Map<Class<?>, AbstractSerializer<?>> getSerializerMap() {
        return (Map<Class<?>, AbstractSerializer<?>>) ApplicationContextHolder.getBean("beanSerializerMap");
    }

}
