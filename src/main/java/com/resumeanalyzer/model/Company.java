package com.resumeanalyzer.model;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private final String companyName;
    private final List<JobPost> jobPosts;

    public Company(String companyName) {
        this.companyName = companyName;
        this.jobPosts = new ArrayList<>();
    }

    public void addJobPost(JobPost job) {
        this.jobPosts.add(job);
    }

    // Getters and Setters
    public String getCompanyName() {
        return companyName;
    }

    public List<JobPost> getJobPosts() {
        return jobPosts;
    }

    // toString() method to read the fields and silence the warning
    @Override
    public String toString() {
        return "Company{" + "companyName='" + this.companyName + '\'' + ", jobPostsCount=" + this.jobPosts.size() + '}';
    }
}