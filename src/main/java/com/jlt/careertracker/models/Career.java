package com.jlt.careertracker.models;

/**
 * Data model used for careers
 */
public class Career {
    /**
     * Name of the position (e.g. Software Engineer, Data Analyst, etc.)
     */
    public String positionName;

    /**
     * Status of the application (e.g. in progress, rejected, accepted, etc.)
     */
    public String status;

    /**
     * Name of the company
     */
    public String companyName;

    /**
     * Empty constructor
     */
    public Career() {}

    /**
     * Constructor for career models
     *
     * @param positionName The name of the position
     * @param status The status of the application
     * @param companyName The name of the company
     */
    public Career(String positionName, String status, String companyName) {
        this.positionName = positionName;
        this.status = status;
        this.companyName = companyName;
    }

    /**
     * Prints out details about an application
     *
     * @return Details about the application
     */
    @Override
    public String toString() {
        return String.format(
          "Career[positionName='%s', status='%s', companyName='%s']",
          positionName, status, companyName
        );
    }
}
