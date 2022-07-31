package com.example.demo.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DemoManager {
    private final JdbcTemplate jdbcTemplate;

    // init/destroy <- in single thread
    // @Bean <- in single thread

    public void incrementCounter() {
        // TODO:
        // UPDATE records SET counter = counter + 1;
        jdbcTemplate.update(
                "UPDATE records SET counter = counter + 1");    }

    public long getCounter() {
        // TODO:
        // SELECT counter FROM records WHERE id = 1;
        return jdbcTemplate.queryForObject(
                "SELECT counter FROM records WHERE id = 1;", Long.class);
    }
}
