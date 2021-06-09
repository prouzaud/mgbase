package com.example.demo.mongoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class MongoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoApiApplication.class, args);
    }

}
