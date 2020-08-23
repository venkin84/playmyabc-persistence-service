package com.playmyabc.persistenceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class PersistenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersistenceServiceApplication.class, args);
    }

}
