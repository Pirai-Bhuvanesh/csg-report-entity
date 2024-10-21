package com.csg.entity.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class JacksonConfigurationTests {

    @InjectMocks
    private JacksonConfiguration configuration; // Replace with your actual configuration class

    @Test
    void testJacksonCustomizer() {
        Jackson2ObjectMapperBuilder builder = Mockito.mock(Jackson2ObjectMapperBuilder.class);

        Jackson2ObjectMapperBuilderCustomizer customizer = configuration.jacksonCustomizer();
        customizer.customize(builder);

        verify(builder).serializerByType(Mockito.eq(Mono.class), Mockito.any(ReactiveTypeSerializer.class));
        verify(builder).deserializerByType(Mockito.eq(Mono.class), Mockito.any(ReactiveTypeDeserializer.class));
        verify(builder).serializerByType(Mockito.eq(Flux.class), Mockito.any(ReactiveTypeSerializer.class));
        verify(builder).deserializerByType(Mockito.eq(Flux.class), Mockito.any(ReactiveTypeDeserializer.class));
    }
}