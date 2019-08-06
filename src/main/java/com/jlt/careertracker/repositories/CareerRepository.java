package com.jlt.careertracker.repositories;

import com.jlt.careertracker.models.Career;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerRepository extends MongoRepository<Career, String> {

    /**
     * Returns a list of all careers with the specified name
     *
     * @param positionName The position name
     * @return All careers with that position name
     */
    public List<Career> findByPositionName(String positionName);

    /**
     * Returns a list of all careers with the specified status
     *
     * @param status The status of the application
     * @return All careers that currently have this status
     */
    public List<Career> findByStatus(String status);

    /**
     * Returns a list of all careers with the specified company name
     *
     * @param companyName The company name
     * @return All careers that are at this company
     */
    public List<Career> findByCompanyName(String companyName);
}
