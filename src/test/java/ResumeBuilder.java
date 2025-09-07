import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResumeBuilder {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Resume myResume = new Resume();
            Analyzer analyzer = new Analyzer();

            System.out.println("Weolcome to the Resume Builder & Analyzer!");
            System.out.println("Let's create your resume step-by-step.");

            System.out.print("Enter your full name: ");
            myResume.setName(scanner.nextLine());
            System.out.print("Enter your email: ");
            myResume.setEmail(scanner.nextLine());
            System.out.print("Enter your phone number: ");
            myResume.setPhoneNumber(scanner.nextLine());

            int choice = 0;
            // Main program loop with a menu
            while (choice != 6) {
                System.out.println("\n--- Main Menu ---");
                System.out.println("1. Add a skill");
                System.out.println("2. Add an education entry");
                System.out.println("3. Add a work experience entry");
                System.out.println("4. Display my current resume");
                System.out.println("5. Analyze my resume against a job post");
                System.out.println("6. Exit and save");
                System.out.print("Enter your choice: ");

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    choice = 0; // Invalid input, will loop again
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter a skill: ");
                        myResume.addSkill(scanner.nextLine());
                        System.out.println("Skill added!");
                        break;
                    case 2:
                        System.out.print("Enter school name: ");
                        String schoolName = scanner.nextLine();
                        System.out.print("Enter degree: ");
                        String degree = scanner.nextLine();
                        System.out.print("Enter year graduated: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        myResume.addEducation(new Education(schoolName, degree, year));
                        System.out.println("Education entry added!");
                        break;
                    case 3:
                        System.out.print("Enter company name: ");
                        String companyName = scanner.nextLine();
                        System.out.print("Enter role: ");
                        String role = scanner.nextLine();
                        System.out.print("Enter duration (e.g., '2 years'): ");
                        String duration = scanner.nextLine();
                        System.out.print("Enter achievements (comma-separated): ");
                        String[] achievementsArray = scanner.nextLine().split(",");
                        List<String> achievements = Arrays.stream(achievementsArray)
                                .map(String::trim)
                                .collect(Collectors.toList());
                        myResume.addExperience(new Experience(companyName, role, duration, achievements));
                        System.out.println("Work experience entry added!");
                        break;
                    case 4:
                        myResume.display();
                        break;
                    case 5:
                        System.out.print("Enter the job title you are applying for: ");
                        String jobTitle = scanner.nextLine();
                        System.out.print("Enter key requirements for the job (comma-separated): ");
                        String[] requirementsArray = scanner.nextLine().split(",");
                        List<String> requirements = Arrays.stream(requirementsArray)
                                .map(String::trim)
                                .collect(Collectors.toList());

                        // Create a JobPost object based on user input
                        JobPost targetJob = new JobPost(jobTitle, requirements, "N/A");

                        // Use the analyzer to get the keyword match score
                        double matchScore = analyzer.keywordMatch(myResume, targetJob);
                        System.out.printf("Your resume has a keyword match score of %.2f%%\n", matchScore);
                        break;
                    case 6:
                        System.out.println("Exiting. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
