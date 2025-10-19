package com.resumeanalyzer.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.resumeanalyzer.model.JobPost;
import com.resumeanalyzer.model.Portfolio;
import com.resumeanalyzer.model.Resume;

/**
 * The core engine responsible for calculating match scores between a Resume and
 * JobPost.
 */
public class Analyzer {

    // ------------------------------------
    // Main Analysis Orchestration Method
    // ------------------------------------

    /**
     * Iterates through all mock job posts and calculates an AnalysisResult for
     * each.
     * 
     * @param resume   The candidate's fully populated resume object.
     * @param jobPosts The list of job targets loaded from the MockDataSource.
     * @return A list of AnalysisResult objects, one for each job post.
     */
    public List<AnalysisResult> analyzeJobs(Resume resume, List<JobPost> jobPosts) {
        List<AnalysisResult> results = new ArrayList<>();

        // Calculate scores that are independent of the specific JobPost first
        double rqScore = calculateResumeQualityScore(resume);
        double pisScore = calculatePortfolioImpactScore(resume.getPortfolio()); // Uses composed object

        for (JobPost job : jobPosts) {
            // Calculate job-specific match score
            double jmsScore = calculateJobMatchScore(resume, job);

            // Create the result object, which also calculates the TMS
            AnalysisResult result = new AnalysisResult(job, jmsScore, rqScore, pisScore);
            results.add(result);
        }
        return results;
    }

    // ------------------------------------
    // Metric 1: Job Matching Score (JMS - Keyword Match)
    // ------------------------------------

    /**
     * Calculates the percentage overlap between candidate skills and required job
     * skills.
     * Simplified Logic: Direct string comparison. [1]
     */
    public double calculateJobMatchScore(Resume resume, JobPost job) {
        List<String> required = job.getRequirements();
        List<String> candidateSkills = resume.getSkills();

        if (required.isEmpty()) {
            return 0.0; // Avoid division by zero
        }

        // Use a set or stream for efficient comparison and counting overlap [2]
        long matchCount = required.stream().filter(req -> candidateSkills.contains(req)).count();

        // Score is the percentage of requirements met
        double score = ((double) matchCount / required.size()) * 100.0;

        // Round to two decimal places
        return Math.round(score * 100.0) / 100.0;
    }

    // ------------------------------------
    // Metric 2: Resume Quality Score (RQ Score - Action Verbs & Readability)
    // ------------------------------------

    /**
     * Calculates a simplified quality score based on action verb usage.
     * Simplified Logic: Counts strong verbs in experience section. [3]
     */
    private double calculateResumeQualityScore(Resume resume) {
        int verbCount = 0;
        List<String> actionVerbs = List.of(
                "Led", "Developed", "Optimized", "Designed", "Managed", "Implemented",
                "Created", "Built", "Directed", "Executed", "Delivered", "Improved",
                "Coordinated", "Analyzed", "Streamlined", "Enhanced", "Supervised", "Launched",
                "Increased", "Reduced", "Negotiated", "Generated", "Achieved", "Resolved",
                "Engineered", "Established", "Organized", "Produced", "Transformed", "Facilitated",
                "Supported", "Trained", "Mentored", "Motivated", "Upgraded", "Automated", "Deployed",
                "Tested", "Debugged", "Refactored", "Monitored", "Configured", "Evaluated",
                "Secured", "Validated", "Researched", "Advised", "Collaborated", "Presented",
                "Influenced", "Drafted", "Authored", "Reviewed", "Defined", "Planned",
                "Forecasted", "Assessed", "Balanced", "Clarified", "Collected", "Compared",
                "Compiled", "Designed", "Outlined", "Prepared", "Programmed", "Proposed",
                "Reconciled", "Reported", "Resolved", "Updated", "Upheld", "Verified",
                "Won", "Saved", "Delivered", "Revamped", "Spearheaded", "Expanded",
                "Pioneered", "Initiated", "Piloted", "Reorganized", "Standardized", "Strengthened",
                "Integrated", "Negotiated", "Drove", "Boosted", "Accomplished", "Oversaw",
                "Executed", "Influenced", "Delegated", "Controlled", "Forecasted", "Presented",
                "Orchestrated", "Implemented", "Directed", "Documented", "Facilitated", "Launched");

        // Combine all achievement strings into one block for analysis
        String allAchievements = resume.getExperienceList().stream()
                .map(exp -> exp.getAchievements()) // Assuming Experience has getAchievements()
                .collect(Collectors.joining(" "));

        // Count occurrences of strong verbs [3]
        for (String verb : actionVerbs) {
            if (allAchievements.contains(verb)) {
                verbCount++;
            }
        }

        // Simple scoring: Max score 30. We give 5 points per verb found, maxing out at
        // 6 verbs.
        double score = Math.min(verbCount * 5.0, 30.0);

        // Add a bonus for length (simplified readability/impact) [4]
        if (allAchievements.split("\\s+").length > 20) {
            score += 5.0;
        }

        // Maximum score capped at 30
        return Math.min(score, 30.0);
    }

    // ------------------------------------
    // Metric 3: Portfolio Impact Score (PIS)
    // ------------------------------------

    /**
     * Calculates the Portfolio Impact Score.
     * This relies on the analyzePortfolio method defined in the Portfolio model
     * class.
     */
    private double calculatePortfolioImpactScore(Portfolio portfolio) {
        // Delegates logic to the composed object itself
        return portfolio.analyzePortfolio();
    }
}