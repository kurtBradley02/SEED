package com.api.demo;
import com.api.demo.serviceobjects.ServiceObjects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RefTestSheet {

    @LocalServerPort
    private int port;

    private ServiceObjects test;

    @BeforeEach
    void setUp() {
        test = new ServiceObjects(port);
    }

    @Test
    void ex1() {
        String expected = "Hello World";
        String actual = test.ex1();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void ex2() {
        int expected = 3;
        int actual = test.ex2(1,2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void ex3() {
        String expected = "3";
        String actual = test.ex3(6,3)[1];
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void ex4() {
        String expected = "Even";
        String actual = test.ex4(2);
        Assertions.assertEquals(expected, actual);
    }


}
