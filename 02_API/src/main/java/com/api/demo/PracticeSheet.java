package com.api.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PracticeSheet {

    @GetMapping("/ex1")
    public String ex1() {
        return "Hello World";
    }

    @GetMapping("/ex2")
    public int ex2(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/ex3")
    public String[] ex3(@RequestParam int a, @RequestParam int b) {
        String result = String.format("SUM: %d, DIF: %d", a + b, a - b);
        return result.split(", ");
    }

    @GetMapping("/ex4")
    public String ex4(@RequestParam int a) {
        return a % 2 == 0 ? "Even" : "Odd";
    }

}
