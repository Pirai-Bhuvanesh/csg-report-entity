package com.csg.entity.config;

import io.r2dbc.spi.ConnectionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class DBConfigTests {

    @InjectMocks
    private DBConfig dbConfig;

    @Mock
    private ConnectionFactory connectionFactory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(dbConfig, "r2dbcUrl", "r2dbc:postgresql://postgres:postgres@localhost:5432/caresoft");
    }

    @Test
    void testConnectionFactory() {
        // Act
        ConnectionFactory factory = dbConfig.connectionFactory();

        // Assert
        assertNotNull(factory, "ConnectionFactory should not be null");
        assertNotNull(factory.create(), "Connection should be creatable from ConnectionFactory");
    }

    @Test
    void testInitializerForCreateConfig() {
        ReflectionTestUtils.setField(dbConfig, "dataConfig", "create");
        ConnectionFactoryInitializer initializer = dbConfig.initializer(connectionFactory);
        assertNotNull(initializer);
    }

    @Test
    void testInitializerForUpdateConfig() {
        ReflectionTestUtils.setField(dbConfig, "dataConfig", "update");
        ConnectionFactoryInitializer initializer = dbConfig.initializer(connectionFactory);
        assertNotNull(initializer);
    }

}
