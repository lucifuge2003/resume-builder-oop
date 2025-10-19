package com.resumeanalyzer.ui;

// classes imports
import java.util.List;
import java.util.Scanner;

import com.resumeanalyzer.model.Education;
import com.resumeanalyzer.model.Experience;
import com.resumeanalyzer.model.Resume;

/**
 * Handles all Q&A style console input to populate the Resume object
 * and its composed/associated data structures (Education, Experience, etc.).
 */
public class ResumeBuilder {
    private final Scanner scanner;

    public ResumeBuilder(Scanner scanner) {
        // scanner instance is passed from MainApp to ensure we only use one scanner for
        // System.in
        this.scanner = scanner;
    }

    /**
     * Guides the user through collecting all necessary resume components.
     * 
     * @return A fully populated Resume object.
     */
    public Resume buildResume() {
        System.out.println("\n╔═════════════════════════════ Resume Builder (Q&A) ════════════════════════════╗");
        System.out.println("        Please answer the prompts below to build your resume");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════╝\n");

        Resume resume = new Resume(); // instantiate the main composite object
        // 1. Collect Personal Information
        collectPersonalInfo(resume);
        // 2. Collect Skills and Certifications (List type)
        collectListItems("Skill", resume.getSkills());
        // 3. Collect Education Records (List of Objects type)
        collectEducationRecords(resume);
        // 4. Collect Experience Records (List of Objects type)
        collectExperienceRecords(resume);
        // (Portfolio input is simple, as it only collects a list of project
        // links/titles)
        collectListItems("Portfolio Project Title/Link", resume.getPortfolio().getProjects());

        System.out.println("--- Resume Building Complete! ---");
        return resume;
    }

    // ------------------------------------------------------------------
    // Private Helper Methods for Collecting Specific Data Types
    // ------------------------------------------------------------------

    /**
     * Collects basic String/Primitive fields (Name, Email, Phone, Age).
     */
    private void collectPersonalInfo(Resume resume) {
        System.out.println("Personal Information:");

        String name = promptNonEmpty("  Full Name: ", "Unknown");
        resume.setName(name);

        String email = promptNonEmpty("  Email: ", "");
        resume.setEmail(email);

        String phone = promptNonEmpty("  Phone: ", "");
        resume.setPhoneNumber(phone);

        int age = promptInt("  Age", 0);
        resume.setAge(age);
    }

    /**
     * Generic helper for collecting simple lists of Strings (Skills,
     * Certifications, Projects).
     */
    private void collectListItems(String itemName, List<String> targetList) {
        System.out.println();
        System.out.println(itemName + " (one per line). Type 'END' to finish.");
        while (true) {
            String input = promptNonEmpty("  > ", "END");
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            targetList.add(input);
        }
    }

    /**
     * Collects complex Education objects and adds them to the Resume.
     */
    private void collectEducationRecords(Resume resume) {
        System.out.println();
        System.out.println("Education Records:");
        if (!promptYesNo("  Would you like to add education entries? (yes/no): ", false)) {
            return;
        }

        while (true) {
            String schoolName = promptNonEmpty("  School Name (or 'END'): ", null);
            if (schoolName.equalsIgnoreCase("END")) {
                break;
            }

            String degree = promptNonEmpty("    Degree/Course: ", null);
            String yearGraduated = promptNonEmpty("    Year Graduated (e.g., 2024): ", null);

            // Instantiate the component object (Education)
            Education edu = new Education(schoolName, degree, yearGraduated);

            // Add the component object to the composite object's list
            resume.addEducation(edu);
        }
    }

    /**
     * Collects complex Experience objects and adds them to the Resume.
     */
    private void collectExperienceRecords(Resume resume) {
        System.out.println();
        System.out.println("Experience / Projects:");
        if (!promptYesNo("  Would you like to add experience/project entries? (yes/no): ", false)) {
            return;
        }

        while (true) {
            String companyName = promptNonEmpty("  Company/Project Name (or 'END')", null);
            if (companyName.equalsIgnoreCase("END")) {
                break;
            }

            String role = promptNonEmpty("    Your Role/Position: ", null);
            String duration = promptNonEmpty("    Duration (e.g., 6 months)", null);

            // NOTE: For the prototype, we are simplifying 'achievements' into one string.
            String achievements = promptNonEmpty(
                    "    Key Achievements (Use strong action verbs like 'Led', 'Developed')", null);

            // Instantiate the component object (Experience)
            Experience exp = new Experience(companyName, role, duration, achievements);

            // Add the component object to the composite object's list
            resume.addExperience(exp);
        }
    }

    // --------------------
    // Input helper methods for validation
    // --------------------

    private String safeReadLine() {
        try {
            return scanner.nextLine().trim();
        } catch (Exception e) {
            return null;
        }
    }

    private String promptNonEmpty(String prompt, String defaultValue) {
        while (true) {
            System.out.print(prompt + ": ");
            String line = safeReadLine();
            if (line == null)
                return defaultValue;
            if (!line.isEmpty())
                return line;
            if (defaultValue != null && !defaultValue.isEmpty())
                return defaultValue;
            System.out.println("    This field cannot be empty. Please enter a value.");
        }
    }

    private boolean promptYesNo(String prompt, boolean defaultYes) {
        while (true) {
            System.out.print(prompt);
            String line = safeReadLine();
            if (line == null)
                return defaultYes;
            if (line.isEmpty())
                return defaultYes;
            line = line.trim().toLowerCase();
            if (line.equals("yes") || line.equals("y"))
                return true;
            if (line.equals("no") || line.equals("n"))
                return false;
            System.out.println("    Please answer 'yes' or 'no'.");
        }
    }

    private int promptInt(String prompt, int defaultValue) {
        while (true) {
            System.out.print(prompt + ": ");
            String line = safeReadLine();
            if (line == null || line.isEmpty())
                return defaultValue;
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("    Please enter a valid integer.");
            }
        }
    }
}