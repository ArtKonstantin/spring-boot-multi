package com.example.demo;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DemoClient {
    public static void main(String[] args) {
        final List<Thread> threads = new ArrayList<>(100);
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                final RestTemplate restTemplate = new RestTemplate();
                for (int j = 0; j < 100_000; j++) {
                    restTemplate.postForObject(
                            "http://localhost:8080/api/counter",
                            null,
                            Void.class
                    );
                }
            }));
        }
        threads.forEach(Thread::start);

    }
}
