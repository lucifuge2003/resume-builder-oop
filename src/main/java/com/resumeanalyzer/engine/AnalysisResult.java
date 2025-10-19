package com.resumeanalyzer.engine;

import java.util.ArrayList;
import java.util.List;

import com.resumeanalyzer.model.JobPost;

/**
 * Data carrier class for the outcome of a single Resume-to-JobPost comparison.
 * The Analyzer creates one of these for every JobPost analyzed.
 */
public class AnalysisResult {

    // ------------------------------------
    // Instance Variables
    // ------------------------------------
    private JobPost jobPost; // The specific job that was analyzed
    private double tmsScore; // Total Match Score (TMS)
    private double jmsScore; // Job Matching Score (Keyword Match)
    private double rqScore; // Resume Quality Score
    private double pisScore; // Portfolio Impact Score
    private List<String> skillGap; // Skills required by the job, but missing from the resume

    // ------------------------------------
    // Constructor (To hold initial data)
    // ------------------------------------
    public AnalysisResult(JobPost jobPost, double jmsScore, double rqScore, double pisScore) {
        this.jobPost = jobPost;
        this.jmsScore = jmsScore;
        this.rqScore = rqScore;
        this.pisScore = pisScore;

        // Calculate the weighted Total Match Score (TMS)
        // Weighting: JMS (60%) + RQ (30%) + PIS (10%)
        this.tmsScore = (jmsScore * 0.60) + (rqScore * 0.30) + (pisScore * 0.10);

        this.skillGap = new ArrayList<>();
    }

    // ------------------------------------
    // Accessor Methods (Getters are essential for MainApp reporting)
    // ------------------------------------

    public JobPost getJobPost() {
        return jobPost;
    }

    public double getTmsScore() {
        return tmsScore;
    }

    public double getJmsScore() {
        return jmsScore;
    }

    public double getRqScore() {
        return rqScore;
    }

    public double getPisScore() {
        return pisScore;
    }

    public List<String> getSkillGap() {
        return skillGap;
    }

    public void setSkillGap(List<String> skillGap) {
        this.skillGap = skillGap;
    }
}