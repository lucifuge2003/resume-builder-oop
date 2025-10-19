package com.resumeanalyzer.engine;

import java.util.ArrayList;
import java.util.List;

import com.resumeanalyzer.model.JobPost;
import com.resumeanalyzer.model.Resume;

/**
 * Generates actionable learning roadmaps based on the skill gap identified
 * between the candidate's Resume and a target JobPost.
 */
public class RoadmapEngine {

    /**
     * Calculates the definitive skill gap between the candidate and the target
     * role.
     * This is achieved by taking all required skills and subtracting possessed
     * skills.
     * 
     * @param targetJob       The JobPost representing the ideal role.
     * @param candidateResume The candidate's resume object.
     * @return A List of Strings representing the missing skills.
     */
    public List<String> generateSkillGap(JobPost targetJob, Resume candidateResume) {

        List<String> requiredSkills = targetJob.getRequirements();
        List<String> candidateSkills = candidateResume.getSkills();

        // Use a mutable copy of the required skills list [1]
        List<String> missingSkills = new ArrayList<>(requiredSkills);

        // Remove all skills the candidate already has from the required list.
        // What remains in missingSkills is the gap.
        missingSkills.removeAll(candidateSkills);

        return missingSkills;
    }

    /**
     * Generates static, suggested learning paths (courses/projects) for the skill
     * gap.
     * Simplified Logic: Maps a missing skill to a fixed learning suggestion.
     * 
     * @param missingSkills The list of skills the candidate is lacking.
     * @return A list of prescriptive learning path suggestions.
     */
    public List<String> suggestCourses(List<String> missingSkills) {
        List<String> suggestions = new ArrayList<>();

        // checks if you have no missing skills
        if (missingSkills == null || missingSkills.isEmpty()) {
            suggestions.add("Congratulations! You have all the core skills for this role.");
            return suggestions;
        }

        // For each missing skill, provide multiple action items: a recommended course,
        // a short project suggestion, and a certification/path where applicable.
        for (String skill : missingSkills) {
            String key = skill.toLowerCase().trim();
            suggestions.add("-- " + skill + " --");
            switch (key) {
                case "spring boot" -> {
                    suggestions.add("Course: Spring Boot 3 Fundamentals (Beginner -> Intermediate)");
                    suggestions.add("Project: Build a RESTful CRUD service with Spring Boot and H2/Postgres");
                    suggestions.add("Certification: Spring Professional (recommended reading and practice)");
                }
                case "python" -> {
                    suggestions.add("Course: Complete 'Python Crash Course' (Hands-on)");
                    suggestions.add("Project: Build a data processing pipeline + small CLI app");
                    suggestions.add("Path: Follow Python for Data Science track if interested in ML");
                }
                case "sql" -> {
                    suggestions.add("Course: Advanced SQL Queries & Database Design");
                    suggestions.add(
                            "Project: Build reports by querying a realistic sample dataset (joins, window functions)");
                    suggestions.add("Practice: Solve SQL problems on LeetCode / Hackerrank daily");
                }
                case "tableau" -> {
                    suggestions.add("Course: Tableau for Data Visualization (Official training)");
                    suggestions.add("Project: Visualize a dataset end-to-end and publish a dashboard");
                    suggestions.add("Certification: Tableau Desktop Specialist");
                }
                case "react" -> {
                    suggestions.add("Course: Modern React with Hooks and Context (practical)");
                    suggestions.add("Project: Build a SPA e-commerce mockup using React + local state or Redux");
                    suggestions.add("Practice: Contribute to an open-source React component library or clone a UI)");
                }
                case "rest api", "restapi" -> {
                    suggestions.add("Course: REST API Design and Implementation (HTTP, JSON, Auth)");
                    suggestions.add("Project: Develop a simple CRUD API using Java/Spring or Node.js/Express");
                    suggestions
                            .add("Practice: Add unit and integration tests to your API and document it with OpenAPI");
                }
                case "statistics" -> {
                    suggestions.add("Course: Introductory Statistics for Data Science");
                    suggestions.add("Project: Perform exploratory analysis and statistical tests on a dataset");
                    suggestions.add("Practice: Apply concepts in small Kaggle notebooks");
                }
                default -> {
                    suggestions.add("Course: Search for beginner-intermediate courses on '" + skill + "'");
                    suggestions.add("Project: Build a small project that uses " + skill + " (practice)");
                }
            }
            // Add a blank line for readability between skills
            suggestions.add("");
        }

        return suggestions;
    }
}