package com.jlt.careertracker.repositories;

import com.jlt.careertracker.models.Career;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CareerRepository extends MongoRepository<Career, String> {

    public List<Career> findByPositionName(String positionName);
    public List<Career> findByStatus(String status);
    public List<Career> findByCompanyName(String companyName);
}
