package com.resumeanalyzer.ui;

// classes imports
import com.resumeanalyzer.model.Resume;
import com.resumeanalyzer.model.Education;
import com.resumeanalyzer.model.Experience;
// utils
import java.util.Scanner;
import java.util.List;

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
        System.out.println("--- Resume Builder: Start Q&A Flow ---");

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
        System.out.println("\n");

        System.out.print("Enter Full Name: ");
        resume.setName(scanner.nextLine().trim());

        System.out.print("Enter Email Address: ");
        resume.setEmail(scanner.nextLine().trim());

        System.out.print("Enter Phone Number: ");
        resume.setPhoneNumber(scanner.nextLine().trim());

        // Simple input for Age (handle potential non-integer input gracefully)
        try {
            System.out.print("Enter Age: ");
            String ageInput = scanner.nextLine().trim();
            if (!ageInput.isEmpty()) {
                resume.setAge(Integer.parseInt(ageInput));
            }
        } catch (NumberFormatException e) {
            System.out.println("Warning: Invalid age entered. Setting age to 0.");
            resume.setAge(0);
        }
    }

    /**
     * Generic helper for collecting simple lists of Strings (Skills,
     * Certifications, Projects).
     */
    private void collectListItems(String itemName, List<String> targetList) {
        System.out.println("\n");
        System.out.println("Enter one " + itemName + " per line. Type 'END' to finish.");

        String input;
        while (true) {
            System.out.print(itemName + " > ");
            input = scanner.nextLine().trim();

            // Exit condition: "END" or empty line
            if (input.equalsIgnoreCase("END") || input.isEmpty()) {
                break;
            }
            // Add the item to the target list (e.g., resume.getSkills().add(input))
            targetList.add(input);
        }
    }

    /**
     * Collects complex Education objects and adds them to the Resume.
     */
    private void collectEducationRecords(Resume resume) {
        System.out.println("\n");
        System.out.println("Do you want to add an education entry? (yes/no)");
        if (!scanner.nextLine().trim().equalsIgnoreCase("yes"))
            return;

        while (true) {
            System.out.print("\nSchool Name (or 'END'): ");
            String schoolName = scanner.nextLine().trim();
            if (schoolName.equalsIgnoreCase("END") || schoolName.isEmpty())
                break;

            System.out.print("Degree/Course: ");
            String degree = scanner.nextLine().trim();

            System.out.print("Year Graduated (e.g., 2024): ");
            String yearGraduated = scanner.nextLine().trim();

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
        System.out.println("\n");
        System.out.println("Do you want to add an experience/project entry? (yes/no)");
        if (!scanner.nextLine().trim().equalsIgnoreCase("yes"))
            return;

        while (true) {
            System.out.print("\nCompany/Project Name (or 'END'): ");
            String companyName = scanner.nextLine().trim();
            if (companyName.equalsIgnoreCase("END") || companyName.isEmpty())
                break;

            System.out.print("Your Role/Position: ");
            String role = scanner.nextLine().trim();

            System.out.print("Duration (e.g., 6 months): ");
            String duration = scanner.nextLine().trim();

            // NOTE: For the prototype, we are simplifying 'achievements' into one string.
            System.out.print("Key Achievements (Use strong action verbs like 'Led', 'Developed'): ");
            String achievements = scanner.nextLine().trim();

            // Instantiate the component object (Experience)
            Experience exp = new Experience(companyName, role, duration, achievements);

            // Add the component object to the composite object's list
            resume.addExperience(exp);
        }
    }
}