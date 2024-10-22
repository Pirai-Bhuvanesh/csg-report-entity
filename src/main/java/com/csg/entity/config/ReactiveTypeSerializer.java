package com.csg.entity.config;

import com.csg.entity.exception.MonoFluxSerializationException;
import com.csg.entity.util.CsgConstants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

public class ReactiveTypeSerializer extends StdSerializer<Object> {

    protected ReactiveTypeSerializer() {
        super(Object.class);
    }

    @Override
    public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (value instanceof Mono) {
            serializeMono((Mono<?>) value, jsonGenerator);
        } else if (value instanceof Flux) {
            serializeFlux((Flux<?>) value, jsonGenerator);
        } else {
            throw new IllegalArgumentException(CsgConstants.UNSUPPORTED_REACTIVE_TYPE + value.getClass().getName());
        }
    }

    private void serializeMono(Mono<?> mono, JsonGenerator jsonGenerator){
        mono.subscribe(monoValue -> {
            try {
                jsonGenerator.writeObject(monoValue);
            } catch (IOException e) {
                throw new MonoFluxSerializationException(CsgConstants.FAILED_SERIALIZE_MONO, e);
            }
        });
    }

    private void serializeFlux(Flux<?> flux, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartArray();
        flux.subscribe(fluxValue -> {
            try {
                jsonGenerator.writeObject(fluxValue);
            } catch (IOException e) {
                throw new MonoFluxSerializationException(CsgConstants.FAILED_SERIALIZE_FLUX, e);
            }
        });
        jsonGenerator.writeEndArray();
    }
}
