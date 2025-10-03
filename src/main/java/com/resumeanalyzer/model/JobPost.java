package com.resumeanalyzer.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a job or internship opportunity posted by a Company.
 * This class serves as the target against which a Resume is analyzed.
 */
public class JobPost {
    // ------------------------------------
    // Instance Variables (Attributes)
    // ------------------------------------
    private String jobTitle;
    private List<String> requirements; // key list for keyword matching
    private String description;

    // ------------------------------------
    // Constructors
    // ------------------------------------

    /**
     * Default constructor: Initializes all list attributes to prevent
     * NullPointerException
     * when adding requirements later via setters or direct list access.
     */
    public JobPost() {
        this.requirements = new ArrayList<>();
    }

    // parameterized constructor for convenience lang
    public JobPost(String jobTitle, List<String> requirements, String description) {
        this.jobTitle = jobTitle;
        this.requirements = requirements;
        this.description = description;
    }

    // ------------------------------------
    // Accessor Methods (Getters and Setters)
    // ------------------------------------

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    // setter used by MockDataSource to set the entire list of skills
    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // utility method to add a single requirement (useful pang build ng posts
    // dynamically)
    public void addRequirement(String requirement) {
        this.requirements.add(requirement);
    }

    // toString method for easy console debugging
    @Override
    public String toString() {
        return "JobPost";
    }
}
