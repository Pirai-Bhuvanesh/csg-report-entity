package com.csg.entity.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ReactiveTypeSerializerTests {

    private final ReactiveTypeSerializer serializer = new ReactiveTypeSerializer();

    @Test
    void testSerializeMono() throws IOException {
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        SerializerProvider mockSerializerProvider = mock(SerializerProvider.class);
        Mono<String> mono = Mono.just("testValue");

        serializer.serialize(mono, mockJsonGenerator, mockSerializerProvider);

        // Verify that jsonGenerator wrote the correct object
        verify(mockJsonGenerator).writeObject("testValue");
    }

    @Test
    void testSerializeFlux() throws IOException {
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        SerializerProvider mockSerializerProvider = mock(SerializerProvider.class);
        Flux<String> flux = Flux.just("value1", "value2", "value3");

        serializer.serialize(flux, mockJsonGenerator, mockSerializerProvider);

        // Verify the structure of the output
        ArgumentCaptor<Object> captor = ArgumentCaptor.forClass(Object.class);
        verify(mockJsonGenerator, times(1)).writeStartArray();
        verify(mockJsonGenerator, times(3)).writeObject(captor.capture());
        verify(mockJsonGenerator, times(1)).writeEndArray();

        // Check that the values captured are what we expect
        assertEquals(3, captor.getAllValues().size());
        assertEquals("value1", captor.getAllValues().get(0));
        assertEquals("value2", captor.getAllValues().get(1));
        assertEquals("value3", captor.getAllValues().get(2));
    }

    @Test
    void testSerializeUnsupportedType() {
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        SerializerProvider mockSerializerProvider = mock(SerializerProvider.class);
        Object unsupportedType = new Object();

        IllegalArgumentException exception =
                org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () ->
                        serializer.serialize(unsupportedType, mockJsonGenerator, mockSerializerProvider));

        assertEquals("Unsupported reactive type: java.lang.Object", exception.getMessage());
    }
}
