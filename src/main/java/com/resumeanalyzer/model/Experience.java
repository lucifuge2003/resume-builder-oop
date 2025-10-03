package com.resumeanalyzer.model;

/**
 * Represents a single professional experience or major project.
 * This is a component object included in the Resume composite object.
 */
public class Experience {
    // ------------------------------------
    // Instance Variables (Attributes)
    // ------------------------------------
    private String companyName;
    private String role;
    private String duration;
    private String achievements;

    // ------------------------------------
    // Constructor (Must match ResumeBuilder input)
    // ------------------------------------

    /**
     * Initializes a new Experience object.
     * Arguments match the input collected by ResumeBuilder.
     */
    public Experience(String companyName, String role, String duration, String achievements) {
        this.companyName = companyName;
        this.role = role;
        this.duration = duration;
        this.achievements = achievements;
    }

    // ------------------------------------
    // Accessor Methods (Getters and Setters)
    // ------------------------------------
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }
}
