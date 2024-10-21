package com.csg.entity.config;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static com.amazonaws.util.ValidationUtils.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReactiveTypeDeserializerTests {

    @InjectMocks
    private ReactiveTypeDeserializer deserializer;

    @Test
    void testDeserializeArrayNode() throws IOException {
        // Arrange
        JsonParser mockParser = mock(JsonParser.class);
        DeserializationContext mockContext = mock(DeserializationContext.class);

        ObjectMapper mapper = new ObjectMapper();
        when(mockParser.getCodec()).thenReturn(mapper);

        when(mockContext.getParser()).thenReturn(mockParser);

        JsonNode arrayNode = mapper.readTree("[1, 2, 3]");

        when(mockParser.readValueAsTree()).thenReturn(arrayNode);

        Object result = deserializer.deserialize(mockParser, mockContext);

        assertNotNull(result, "The result should not be null");

    }

    @Test
    void testDeserializeObjectNode() throws IOException {
        JsonParser mockParser = mock(JsonParser.class);
        DeserializationContext mockContext = mock(DeserializationContext.class);

        ObjectMapper mapper = new ObjectMapper();
        when(mockParser.getCodec()).thenReturn(mapper);

        when(mockContext.getParser()).thenReturn(mockParser);

        JsonNode objectNode = mapper.readTree("{\"key\": \"value\"}");

        when(mockParser.readValueAsTree()).thenReturn(objectNode);

        Object result = deserializer.deserialize(mockParser, mockContext);

        assertNotNull(result, "The result should not be null");
    }
}