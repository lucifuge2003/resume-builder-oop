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
        if (missingSkills.isEmpty()) {
            suggestions.add("Congratulations! You have all the core skills for this role.");
            return suggestions;
        }

        suggestions.add("--- Suggested Learning Roadmap ---");

        // TODO: dont forgot mag lagay additional suggestions here as you add more
        for (String skill : missingSkills) {
            String suggestion = switch (skill.toLowerCase()) {
                case "spring boot" -> "Take 'Spring Boot 3 Fundamentals' course.";
                case "python" -> "Complete 'Python Crash Course' project.";
                case "sql" -> "Practice with 'Advanced SQL Queries' challenges.";
                case "tableau" -> "Complete the Tableau Desktop Specialist certification track.";
                case "react" -> "Build a simple single-page application (SPA) using React.";
                case "rest api" -> "Develop a simple CRUD API using Java/Spring.";
                default -> "Target skill: " + skill + " (Search for beginner courses/tutorials)";
            };
            suggestions.add(suggestion);
        }

        return suggestions;
    }
}