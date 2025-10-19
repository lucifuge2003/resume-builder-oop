package com.resumeanalyzer.data;

//classes imports 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.resumeanalyzer.model.JobPost;

public class MockDataSource {
    public MockDataSource() {
    }

    // main method to generate mock job posts
    public List<JobPost> generateMockJobPosts() {
        List<JobPost> jobPosts = new ArrayList<>();

        jobPosts.add(createJavaDeveloperPost());
        jobPosts.add(createDataAnalystInternship());
        jobPosts.add(createWebDevRole());
        // Additional mock job posts can be added here
        return jobPosts;
    }

    // ------------------------------------------------------------------------------
    // private helper methods for creating specific job posts can be added here
    // ------------------------------------------------------------------------------

    private static JobPost createJavaDeveloperPost() {
        JobPost job = new JobPost();
        // Assuming JobPost has setter methods, or we pass data to the constructor
        job.setJobTitle("Junior Java Developer (Full-Stack)");
        job.setDescription("Development role focusing on backend Java APIs and database integration.");

        // Populate the list of required skills/keywords
        List<String> requirements = Arrays.asList(
                "Java",
                "OOP",
                "Spring Boot",
                "REST API",
                "SQL",
                "Git");
        job.setRequirements(requirements);

        return job;
    }

    private static JobPost createDataAnalystInternship() {
        JobPost job = new JobPost();
        job.setJobTitle("Data Analyst Internship");
        job.setDescription("Internship focused on data cleansing, visualization, and report generation.");

        List<String> requirements = Arrays.asList(
                "Python",
                "Data Analysis",
                "SQL",
                "Excel",
                "Statistics",
                "Tableau");
        job.setRequirements(requirements);

        return job;
    }

    private static JobPost createWebDevRole() {
        JobPost job = new JobPost();
        job.setJobTitle("Frontend Web Developer");
        job.setDescription("Develop and maintain client-side web applications.");

        List<String> requirements = Arrays.asList(
                "HTML",
                "CSS",
                "JavaScript",
                "React",
                "UI/UX Principles");
        job.setRequirements(requirements);

        return job;
    }
}
