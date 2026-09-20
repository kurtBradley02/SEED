package com.api.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RefDemoDBController {

    private final JdbcTemplate jdbcTemplate;

    public RefDemoDBController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/refdb/{id}")
    public Map<String, Object> getById(@PathVariable int id) {
        return jdbcTemplate.queryForMap("SELECT * FROM tbldemodb WHERE id = ?", id);
    }

    @GetMapping("/ex1")
    public String ex1() {
        return "Hello World";
    }

}