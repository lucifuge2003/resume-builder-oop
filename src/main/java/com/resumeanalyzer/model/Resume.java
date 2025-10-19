package com.resumeanalyzer.model;

import java.util.ArrayList;
import java.util.List;

public class Resume {
    // ------------------------------------
    // Instance Variables (Attributes)
    // ------------------------------------
    private String name;
    private int age;
    private String email;
    private String phoneNumber;
    private final List<String> skills;
    private final List<Education> educationList;
    private final List<Experience> experienceList;
    private final List<String> certifcations;
    private final Portfolio portfolio;
    private double resumeScore;

    // ------------------------------------
    // Constructors
    // ------------------------------------
    public Resume() {
        this.skills = new ArrayList<>();
        this.educationList = new ArrayList<>();
        this.experienceList = new ArrayList<>();
        this.certifcations = new ArrayList<>();
        this.portfolio = new Portfolio();
        this.resumeScore = 0.0;
    }

    // ------------------------------------
    // Accessor Methods (Getters and Setters)
    // ------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<String> getSkills() {
        return skills;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public List<String> getCertifcations() {
        return certifcations;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public double getResumeScore() {
        return resumeScore;
    }

    public void setResumeScore(double resumeScore) {
        this.resumeScore = resumeScore;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public void addEducation(Education edu) {
        this.educationList.add(edu);
    }

    public void addExperience(Experience exp) {
        this.experienceList.add(exp);
    }

    public void addCertification(String cert) {
        this.certifcations.add(cert);

    }

    public String generateResumeTemplate() {
        // TODO: implement logic to generate resume template
        return "Resume for " + this.name + " with " + this.skills.size() + " skills.";
    }

    public double analyzeResume() {
        return 0.0;
    }

    public String getSuggestions() {
        return "";
    }
}
