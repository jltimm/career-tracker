package com.jlt.careertracker.models;

public class Career {
    public String positionName;
    public String status;
    public String companyName;

    public Career() {}

    public Career(String positionName, String status, String companyName) {
        this.positionName = positionName;
        this.status = status;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return String.format(
          "Career[positionName='%s', status='%s', companyName='%s']",
          positionName, status, companyName
        );
    }
}
