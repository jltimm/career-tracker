package com.jlt.careertracker.controllers;

import com.jlt.careertracker.models.Career;
import com.jlt.careertracker.repositories.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for job applications
 */
@RestController
public class CareerController {

    /**
     * Collection where all career information lives
     */
    @Autowired
    private CareerRepository careerRepository;

    /**
     * Grabs list of all the job applications from repository, no
     * matter the progress
     *
     * @return All the careers
     */
    @GetMapping("/careers")
    public List<Career> getCareers() {
        return careerRepository.findAll();
    }
}
