package org.meleschkin;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meleschkin.controller.HelloWorldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SuppressWarnings("ALL")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@Log4j2
class MyTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    HelloWorldController controler;

    @MockBean
    HelloWorldController mockControler;

    @BeforeEach
    public void init() {
        when(this.mockControler.index()).thenReturn("index");
    }

    @Test
    void myTest() {
        ResponseEntity<String> result = restTemplate.getForEntity("/", String.class);
        log.info(result.getBody());
        if (result.getBody() == null)
            fail();
        assertTrue(result.getBody().contains("Spring Boot Training - Hello World"));
    }

    @Test
    void controler() {
        String result = controler.index();
        log.info(result);
        assertNotNull(result);
    }

}
