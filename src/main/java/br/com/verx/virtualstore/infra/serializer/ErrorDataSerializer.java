package br.com.verx.virtualstore.infra.serializer;

import br.com.verx.virtualstore.infra.exception.ErrorData;
import java.io.IOException;
import lombok.AllArgsConstructor;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
public class ErrorDataSerializer extends AbstractSerializer<ErrorData> {

    @Override
    protected void serialize(final ErrorData errorData, final JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeNumberField(Field.CODE, errorData.getCode());
        jsonWriter.writeStringField(Field.MESSAGE, errorData.getMessage());
        jsonWriter.writeEndObject();
    }

    @AllArgsConstructor
    private enum Field {

        CODE("code"),
        MESSAGE("message");

        private final String label;

        @Override
        public String toString() {
            return this.label;
        }

    }

}
