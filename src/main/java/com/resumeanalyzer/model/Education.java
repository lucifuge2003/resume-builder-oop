package com.resumeanalyzer.model;

/**
 * Represents a single academic achievement or training record.
 * This is a component object included in the Resume composite object.
 */
public class Education {
    // ------------------------------------
    // Instance Variables (Attributes)
    // ------------------------------------
    private String schoolName;
    private String degree;
    private String yearGraduated;

    // ------------------------------------
    // Constructor (Must match ResumeBuilder input)
    // ------------------------------------

    /**
     * Initializes a new Education object.
     * Arguments match the input collected by ResumeBuilder.
     */
    public Education(String schoolName, String degree, String yearGraduated) {
        this.schoolName = schoolName;
        this.degree = degree;
        this.yearGraduated = yearGraduated;
    }

    // ------------------------------------
    // Accessor Methods (Getters and Setters)
    // ------------------------------------

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getYearGraduated() {
        return yearGraduated;
    }

    public void setYearGraduated(String yearGraduated) {
        this.yearGraduated = yearGraduated;
    }
}
