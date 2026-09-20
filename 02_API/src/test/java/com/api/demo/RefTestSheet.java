package com.api.demo;
import com.api.demo.serviceobjects.RefServiceObjects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RefTestSheet {

    @LocalServerPort
    private int port;

    private RefServiceObjects test;

    @BeforeEach
    void setUp() {
        test = new RefServiceObjects(port);
    }

    @Test
    public void ex1()
    {
        String expected = "Hello World";
        String actual = test.ex1();
        assertEquals(expected, actual);
    }

 

}
