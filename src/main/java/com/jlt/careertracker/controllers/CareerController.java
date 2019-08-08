package com.jlt.careertracker.controllers;

import com.jlt.careertracker.models.Career;
import com.jlt.careertracker.repositories.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * Constructor for CareerController
     *
     * @param careerRepository The career repository
     */
    public CareerController(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    /**
     * Grabs list of all the job applications from repository
     *
     * @return All the careers
     */
    @GetMapping(value = "/careers")
    public List<Career> getCareers() {
        return careerRepository.findAll();
    }
}
