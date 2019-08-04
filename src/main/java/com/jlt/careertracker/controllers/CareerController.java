package com.jlt.careertracker.controllers;

import com.jlt.careertracker.models.Career;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CareerController {

    @GetMapping("/careers")
    public List<Career> getCareers() {
        return new ArrayList<Career>() {{
            add(new Career("Software Engineer", "no response", "Company 1"));
            add(new Career("Software Engineer", "no response", "Company 1"));
        }};
    }
}
