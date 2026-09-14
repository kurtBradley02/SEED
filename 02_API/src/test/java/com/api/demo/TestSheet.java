package com.api.demo;
import com.api.demo.serviceobjects.ServiceObjects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestSheet {

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
        String expected = "Hello World";
        String actual = test.ex1();
        assertEquals(expected, actual);
    }

    @Test
    public void ex2()
    {
        int expected = 3;
        int actual = test.ex2(1,2);
        assertEquals(expected, actual);
    }

    @Test
    public void ex3(){
        String expected = "3";
        String actual = test.ex3(6,3)[1];
        assertEquals(expected, actual);
    }

    @Test
    public void ex4(){
        String expected = "Even";
        String actual = test.ex4(2);
        assertEquals(expected, actual);
    }


}
