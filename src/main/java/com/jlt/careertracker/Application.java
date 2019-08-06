package com.jlt.careertracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.controllers", "com.repositories"})
public class Application {

    /**
     * Entry point for application.
     *
     * @param args The args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
