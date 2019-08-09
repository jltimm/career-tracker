package com.jlt.careertracker;

import com.jlt.careertracker.models.Career;
import com.jlt.careertracker.repositories.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    /**
     * Repository for careers so we can seed data on startup.
     */
    @Autowired
    private CareerRepository careerRepository;

    /**
     * Entry point for application.
     *
     * @param args The args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Seed the repository with a couple values
     *
     * @param args The args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        careerRepository.deleteAll();
        careerRepository.save(new Career("Software Engineer", "in progress", "Company 1"));
        careerRepository.save(new Career("Software Engineer", "in progress", "Company 2"));
    }
}
