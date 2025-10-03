package com.resumeanalyzer.model;

import java.util.List;
import java.util.ArrayList;

public class Resume {
    private String name;
    private int age;
    private String email;
    private String phoneNumber;
    private List<String> skills;
    private List<Education> educationList;
    private List<Experience> experienceList;
    private List<String> certifcations;
    private Portfolio portfolio;
    private double resumeScore;

    public Resume() {
        this.skills = new ArrayList<>();
        this.educationList = new ArrayList<>();
        this.experienceList = new ArrayList<>();
        this.certifcations = new ArrayList<>();
        this.portfolio = new Portfolio();
        this.resumeScore = 0.0;
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
