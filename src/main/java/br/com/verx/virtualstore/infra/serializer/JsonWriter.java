package br.com.verx.virtualstore.infra.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;

/**
 * Just a helper to write json that is returning
 *
 * @author José Carlos Mazella Junior
 * @version 1.0 08/10/2018
 */
@AllArgsConstructor
public class JsonWriter {

    private final JsonGenerator generator;
    private final boolean writeNullable = Boolean.TRUE;

    public void writeStartObject() throws IOException {
        this.generator.writeStartObject();
    }

    public void writeObjectFieldStart(Enum<?> fieldName) throws IOException {
        if (fieldName != null) {
            this.generator.writeObjectFieldStart(fieldName.toString());
        } else {
            this.generator.writeStartObject();
        }

    }

    public void writeNumberField(Enum<?> fieldName, BigDecimal value) throws IOException {
        if (value != null) {
            this.generator.writeNumberField(fieldName.toString(), value);
        } else if (this.writeNullable) {
            this.generator.writeStringField(fieldName.toString(), "");
        }

    }

    public void writeNumberField(Enum<?> fieldName, Long value) throws IOException {
        if (value != null) {
            this.generator.writeNumberField(fieldName.toString(), value);
        } else if (this.writeNullable) {
            this.generator.writeStringField(fieldName.toString(), "");
        }

    }

    public void writeNumberField(Enum<?> fieldName, Integer value) throws IOException {
        if (value != null) {
            this.generator.writeNumberField(fieldName.toString(), value);
        } else if (this.writeNullable) {
            this.generator.writeStringField(fieldName.toString(), "");
        }

    }

    public void writeStringField(Enum<?> fieldName, String value) throws IOException {
        if (value != null) {
            this.generator.writeStringField(fieldName.toString(), value);
        } else if (this.writeNullable) {
            this.generator.writeStringField(fieldName.toString(), "");
        }

    }

    public void writeStringField(Enum<?> fieldName, Enum<?> enumeratedValue) throws IOException {
        if (enumeratedValue != null) {
            this.writeStringField(fieldName, enumeratedValue.name());
        } else if (this.writeNullable) {
            this.generator.writeStringField(fieldName.toString(), "");
        }

    }

    public void writeBooleanField(Enum<?> fieldName, Boolean value) throws IOException {
        if (value != null) {
            this.generator.writeBooleanField(fieldName.toString(), value);
        } else if (this.writeNullable) {
            this.generator.writeStringField(fieldName.toString(), "");
        }

    }

    public void writeArrayFieldStart(Enum<?> fieldName) throws IOException {
        this.generator.writeArrayFieldStart(fieldName.toString());
    }

    public void writeString(String text) throws IOException {
        this.generator.writeString(text);
    }

    public void writeNumber(Long value) throws IOException {
        this.generator.writeNumber(value);
    }

    public void writeStartArray() throws IOException {
        this.generator.writeStartArray();
    }

    public void writeEndArray() throws IOException {
        this.generator.writeEndArray();
    }

    public void writeEndObject() throws IOException {
        this.generator.writeEndObject();
    }

    public void writeObject(Object value) throws IOException {
        this.generator.writeObject(value);
    }

}
