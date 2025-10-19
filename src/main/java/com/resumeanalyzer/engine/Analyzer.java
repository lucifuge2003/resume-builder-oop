package com.resumeanalyzer.engine;

// classes imports
import com.resumeanalyzer.model.*;

// utils
import java.util.List;
import java.util.ArrayList;

public class Analyzer {

    public double calculateTotalMatchScore(Resume resume, JobPost job) {
        return 0.0;
    }

    public double keywordMatch(Resume resume, JobPost job) {
        return 0.0;
    }

    public double readabilityScore(Resume resume) {
        return 0.0;
    }

    public double impactScore(Portfolio resume) {
        return 0.0;
    }

    public List<AnalysisResult> analyzeJobs(Resume resume, List<JobPost> jobPosts) {
        return java.util.Collections.emptyList();
    }

}
