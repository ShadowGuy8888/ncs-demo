package com.example.ncs_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Uses a random port
class NcsDemoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    // This test ensures the application context loads correctly
    @Test
    void contextLoads() {
    }

    // This is an integration test for our / endpoint
    @Test
    void helloEndpointReturnsDefaultMessage() {
        String url = "http://localhost:" + port + "/";
        assertThat(this.restTemplate.getForObject(url, String.class))
                .contains("Hello from my CI/CD pipeline!");
    }
}
