package com.api.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefDemoController {

    @GetMapping("/refex1")
    public String ex1() {
        return "Hello World";
    }

    @GetMapping("/refex2")
    public int ex2(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/refex3")
    public String[] ex3(@RequestParam int a, @RequestParam int b) {
        String result = String.format("SUM: %d, DIF: %d", a + b, a - b);
        return result.split(", ");
    }

    @GetMapping("/refex4")
    public String ex4(@RequestParam int a) {
        return a % 2 == 0 ? "Even" : "Odd";
    }

}
