package org.meleschkin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.meleschkin.controller.HelloWorldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SuppressWarnings("ALL")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MyTest {
    Log LOG = LogFactory.getLog(MyTest.class);

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    HelloWorldController controler;

    @MockBean
    HelloWorldController mockControler;

    @Before
    public void init() {
        when(this.mockControler.index()).thenReturn("index");
    }

    @Test
    public void myTest() {
        ResponseEntity<String> result = restTemplate.getForEntity("/", String.class);
        LOG.info(result.getBody());
        if (result.getBody() == null)
            fail();
        assertTrue(result.getBody().contains("Spring Boot Training - Hello World"));
    }

    @Test
    public void controler() {
        String result = controler.index();
        LOG.info(result);
        assertNotNull(result);
    }

}