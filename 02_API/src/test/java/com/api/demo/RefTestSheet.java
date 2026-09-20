package com.api.demo;
import com.api.demo.serviceobjects.ServiceObjects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void ex1()
    {
        String expected = "{\"id\":1,\"a\":1,\"b\":0}";
        String actual = test.ex1();
        assertEquals(expected, actual);
    }

 

}
