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
        jobPosts.add(createMobileAppDevRole());
        jobPosts.add(createDevOpsRole());
        jobPosts.add(createMLEngineerRole());
        jobPosts.add(createUXDesignerRole());
        jobPosts.add(createCyberSecurityRole());
        jobPosts.add(createProductManagerRole());
        jobPosts.add(createCloudArchitectRole());
        jobPosts.add(createBIAnalystRole());
        jobPosts.add(createQAEngineerRole());
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

    private static JobPost createMobileAppDevRole() {
        JobPost job = new JobPost();
        job.setJobTitle("Mobile Application Developer");
        job.setDescription("Design and develop cross-platform mobile applications using modern frameworks.");

        List<String> requirements = Arrays.asList(
                "Flutter",
                "Dart",
                "React Native",
                "iOS Development",
                "Android Development",
                "Mobile UI Design",
                "REST APIs",
                "Git");
        job.setRequirements(requirements);

        return job;
    }

    private static JobPost createDevOpsRole() {
        JobPost job = new JobPost();
        job.setJobTitle("DevOps Engineer");
        job.setDescription("Implement and maintain CI/CD pipelines, cloud infrastructure, and automation tools.");

        List<String> requirements = Arrays.asList(
                "Docker",
                "Kubernetes",
                "AWS/Azure",
                "Jenkins",
                "Linux",
                "Shell Scripting",
                "Python",
                "Infrastructure as Code",
                "Git");
        job.setRequirements(requirements);

        return job;
    }

    private static JobPost createMLEngineerRole() {
        JobPost job = new JobPost();
        job.setJobTitle("Machine Learning Engineer");
        job.setDescription("Develop and deploy machine learning models for production environments.");

        List<String> requirements = Arrays.asList(
                "Python",
                "TensorFlow",
                "PyTorch",
                "Scikit-learn",
                "Deep Learning",
                "Data Processing",
                "SQL",
                "Cloud ML Platforms",
                "Git");
        job.setRequirements(requirements);

        return job;
    }

    private static JobPost createUXDesignerRole() {
        JobPost job = new JobPost();
        job.setJobTitle("UX/UI Designer");
        job.setDescription("Create intuitive and engaging user experiences for web and mobile applications.");

        List<String> requirements = Arrays.asList(
                "Figma",
                "Adobe XD",
                "User Research",
                "Wireframing",
                "Prototyping",
                "Visual Design",
                "HTML/CSS",
                "Design Systems",
                "User Testing");
        job.setRequirements(requirements);

        return job;
    }

    private static JobPost createCyberSecurityRole() {
        JobPost job = new JobPost();
        job.setJobTitle("Cybersecurity Analyst");
        job.setDescription("Monitor, detect, investigate, and respond to cybersecurity threats and incidents.");

        List<String> requirements = Arrays.asList(
                "Network Security",
                "Security Tools",
                "Penetration Testing",
                "SIEM Tools",
                "Python",
                "Linux",
                "Security Certifications",
                "Incident Response",
                "Risk Assessment");
        job.setRequirements(requirements);

        return job;
    }

    private static JobPost createProductManagerRole() {
        JobPost job = new JobPost();
        job.setJobTitle("Product Manager");
        job.setDescription(
                "Lead product strategy, define roadmaps, and work with engineering and design teams to deliver features.");

        List<String> requirements = Arrays.asList(
                "Product Management",
                "Roadmapping",
                "Stakeholder Management",
                "Metrics/Analytics",
                "Communication",
                "SQL");
        job.setRequirements(requirements);

        return job;
    }

    private static JobPost createCloudArchitectRole() {
        JobPost job = new JobPost();
        job.setJobTitle("Cloud Solutions Architect");
        job.setDescription(
                "Design and operate scalable cloud systems, advise on architecture, and manage infrastructure as code.");

        List<String> requirements = Arrays.asList(
                "AWS",
                "Azure",
                "Terraform",
                "Cloud Architecture",
                "Kubernetes",
                "Security");
        job.setRequirements(requirements);

        return job;
    }

    private static JobPost createBIAnalystRole() {
        JobPost job = new JobPost();
        job.setJobTitle("Business Intelligence Analyst");
        job.setDescription("Build dashboards, ETL pipelines, and data models to provide actionable business insights.");

        List<String> requirements = Arrays.asList(
                "Power BI",
                "ETL",
                "Data Warehousing",
                "SQL",
                "DAX",
                "Data Modeling");
        job.setRequirements(requirements);

        return job;
    }

    private static JobPost createQAEngineerRole() {
        JobPost job = new JobPost();
        job.setJobTitle("QA Automation Engineer");
        job.setDescription("Design and implement automated test suites and integrate testing into CI/CD pipelines.");

        List<String> requirements = Arrays.asList(
                "Selenium",
                "Test Automation",
                "Java",
                "CI/CD",
                "JUnit/TestNG",
                "Automation Frameworks");
        job.setRequirements(requirements);

        return job;
    }
}
