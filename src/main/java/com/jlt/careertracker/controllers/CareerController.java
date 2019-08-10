package com.jlt.careertracker.controllers;

import com.jlt.careertracker.models.Career;
import com.jlt.careertracker.repositories.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * Controller for job applications
 */
@RestController
@RequestMapping("/api")
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
    @GetMapping("/careers")
    public List<Career> getCareers() {
        return careerRepository.findAll();
    }

    /**
     * Gets an application based on its ID
     *
     * @param id ID of the application
     * @return The career if it exists, otherwise not found.
     */
    @GetMapping("/career/{id}")
    ResponseEntity<?> getApplication(@PathVariable String id) {
        Optional<Career> career = careerRepository.findById(id);
        return career.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Adds an application to the repository
     *
     * @param career The career, must be sent in application/json
     * @return The created career as a response entity
     * @throws URISyntaxException
     */
    @PostMapping("/career")
    ResponseEntity<Career> createApplication(@Valid @RequestBody Career career) throws URISyntaxException {
        Career result = careerRepository.save(career);
        return ResponseEntity.created(new URI("/api/career/" + result.getId())).body(result);
    }

    /**
     * Updates an existing application, saves it to the repository
     *
     * @param career The career to update
     * @return The saved career as a response entity
     */
    @PutMapping("/career")
    ResponseEntity<Career> updateApplication(@Valid @RequestBody Career career) {
        Career result = careerRepository.save(career);
        return ResponseEntity.ok().body(result);
    }

    /**
     * Deletes an application from the repository
     *
     * @param id The ID of the application
     * @return an OK response
     */
    @DeleteMapping("/career/{id}")
    ResponseEntity<?> deleteApplication(@PathVariable String id) {
        careerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
