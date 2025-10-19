package com.resumeanalyzer.ui;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.resumeanalyzer.data.MockDataSource;
import com.resumeanalyzer.engine.AnalysisResult;
import com.resumeanalyzer.engine.Analyzer;
import com.resumeanalyzer.engine.RoadmapEngine;
import com.resumeanalyzer.model.JobPost;
import com.resumeanalyzer.model.Resume;

/**
 * The main application class and entry point.
 * Orchestrates the flow: Input -> Data Load -> Analysis -> Output.
 */
public class MainApp {
    // Main entry point for the application
    public static void main(String[] args) {
        // Use a try-with-resources block to ensure the Scanner is closed automatically.
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

        System.out.println("====================================================================");
        System.out.println("              RESUME BUILDER AND ANALYZER (OOP PROTOTYPE)          ");
        System.out.println("====================================================================");
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
        // Execute the main analysis method
        List<AnalysisResult> results = analyzer.analyzeJobs(candidateResume, mockJobs);

        // ----------------------------------------------------
        // 4. ROADMAP & OUTPUT PHASE: Process Results and Generate Report
        // ----------------------------------------------------
        RoadmapEngine roadmapEngine = new RoadmapEngine();

        // Sort the results by Total Match Score (TMS) descending
        results.sort(Comparator.comparing(AnalysisResult::getTmsScore).reversed());

        // Iterate through the results to generate the skill gap for the top matches
        for (AnalysisResult result : results) {
            // Generate the skill gap
            List<String> gap = roadmapEngine.generateSkillGap(result.getJobPost(), candidateResume);
            result.setSkillGap(gap);
        }
        // Display the final output
        displayReport(results, roadmapEngine);
    }

    /**
     * Displays the final analysis report to the console.
     */
    public void displayReport(List<AnalysisResult> results, RoadmapEngine roadmapEngine) {

        System.out.println("\n==================================================================");
        System.out.println("                         ANALYSIS REPORT CARD                       ");
        System.out.println("===================================================================");

        if (results.isEmpty()) {
            System.out.println("No job matches found.");
            return;
        }
        System.out.println("\n--- Top 3 Job Matches (Sorted by TMS) ---");

        for (int i = 0; i < Math.min(3, results.size()); i++) {
            AnalysisResult result = results.get(i);
            JobPost job = result.getJobPost();

            System.out.printf("\n%d. %s (TMS: %.2f%% Suitability)\n",
                    i + 1, job.getJobTitle(), result.getTmsScore());
            System.out.printf("   > Keyword Match (JMS): %.2f%%\n", result.getJmsScore());
            System.out.printf("   > Resume Quality (RQ): %.2f%%\n", result.getRqScore());
            System.out.printf("   > Portfolio Impact (PIS): %.2f%%\n", result.getPisScore());

            // --- Roadmap for the Top Match ---
            if (i == 0) {
                System.out.println("\n--- Targeted Skill Gap for BEST MATCH ---");
                if (result.getSkillGap().isEmpty()) {
                    System.out.println("\nGoal Achieved! No significant skill gaps found.");
                } else {
                    System.out.println();
                    System.out.println("Missing Skills:");
                    for (String missing : result.getSkillGap()) {
                        System.out.println("   • " + missing);
                    }

                    // --- Suggested Courses ---
                    List<String> suggestions = roadmapEngine.suggestCourses(result.getSkillGap());
                    System.out.println();
                    System.out.println(
                            "╔══════════════════════════ Suggested Learning Roadmap ═════════════════════════╗");
                    for (String suggestion : suggestions) {
                        if (suggestion.startsWith("-- ") && suggestion.endsWith(" --")) {
                            // skill title
                            System.out.println();
                            System.out.println("  " + suggestion);
                        } else if (suggestion.isBlank()) {
                            // spacer
                            System.out.println();
                        } else {
                            System.out.println("    - " + suggestion);
                        }
                    }
                    System.out.println(
                            "╚═══════════════════════════════════════════════════════════════════════════════╝");
                }
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        System.out.println("\n=================================================");
    }
}