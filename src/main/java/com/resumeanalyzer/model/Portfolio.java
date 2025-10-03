package com.resumeanalyzer.model;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    // ------------------------------------
    // Instance Variables (Attributes)
    // ------------------------------------
    private List<String> projects;
    private double credibility;
    private double rating;

    // ------------------------------------
    // Constructors
    // ------------------------------------
    public Portfolio() {
        this.projects = new ArrayList<>(); // Initialize the list to prevent NPE
        this.credibility = 0.0;
        this.rating = 0.0;
    }

    // ------------------------------------
    // Required Methods (Behavior)
    // ------------------------------------

    /**
     * Fulfills the Portfolio Analyzer feature requirement.
     * Simplified logic: returns a base score if projects exist,
     * otherwise returns 0.
     * 
     * @return The Portfolio Impact Score (PIS).
     */
    public double analyzePortfolio() {
        // Simplified Logic: Assigns a score based on quantity of projects.
        if (this.projects.size() >= 2) {
            return 10.0; // Higher score for multiple projects
        } else if (this.projects.size() == 1) {
            return 5.0; // Base score for at least one project
        } else {
            return 0.0; // No projects
        }
    }

    // ------------------------------------
    // Accessor Methods (Getters and Setters)
    // ------------------------------------

    /**
     * Required accessor method for ResumeBuilder to populate the list.
     * The ResumeBuilder uses this to pass the list reference to collectListItems().
     */
    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public double getCredibility() {
        return credibility;
    }

    public void setCredibility(double credibility) {
        this.credibility = credibility;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
