package com.resumeanalyzer.ui;

// Imports for orchestration
import java.util.List;
import java.util.Scanner;

import com.resumeanalyzer.data.MockDataSource;
import com.resumeanalyzer.engine.Analyzer;
import com.resumeanalyzer.model.JobPost;
import com.resumeanalyzer.model.Resume;

/**
 * The main application class and entry point.
 * Orchestrates the flow: Input -> Data Load -> Analysis -> Output.
 */
public class MainApp {
    // Main entry point for the application
    public static void main(String args) {
        // Use a try-with-resources block to ensure the Scanner is closed automatically.
        // [1]
        try (Scanner scanner = new Scanner(System.in)) {
            MainApp app = new MainApp();
            app.runApplication(scanner);
        } catch (Exception e) {
            System.err.println("An unexpected error occurred during execution: " + e.getMessage());
        }
    }

    /**
     * Controls the sequence of application steps: Build -> Load -> Analyze.
     */
    public void runApplication(Scanner scanner) {

        System.out.println("=================================================");
        System.out.println("  RESUME BUILDER AND ANALYZER (OOP PROTOTYPE)  ");
        System.out.println("=================================================");
        // ----------------------------------------------------
        // 1. BUILD PHASE: Collect Resume Data from User
        // ----------------------------------------------------
        ResumeBuilder builder = new ResumeBuilder(scanner);
        Resume candidateResume = builder.buildResume();

        // Basic check to see if the user entered their name
        if (candidateResume.getName() == null || candidateResume.getName().trim().isEmpty()) {
            System.out.println("\nApplication terminated: No resume data provided.");
            return;
        }

        System.out.println("\n--- Resume Built Successfully ---");
        System.out.println("Candidate: " + candidateResume.getName());
        // ----------------------------------------------------
        // 2. DATA LOAD PHASE: Get Mock Comparison Targets
        // ----------------------------------------------------
        MockDataSource dataSource = new MockDataSource();
        List<JobPost> mockJobs = dataSource.generateMockJobPosts();
        System.out.println("Loaded " + mockJobs.size() + " mock job opportunities for comparison.");

        // ----------------------------------------------------
        // 3. ANALYSIS PHASE: Prepare for Logic Execution
        // ----------------------------------------------------
        // Instantiate the Analyzer. This object is associated with (uses) the data
        // objects.
        Analyzer analyzer = new Analyzer();
        System.out.println("Analyzer Engine initialized. Ready to process data...");

        System.out.println("\n*** Proceed to Step 4: Implement Analyzer.java ***");
    }

}