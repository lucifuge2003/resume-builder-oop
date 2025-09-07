import java.util.ArrayList;
import java.util.List;

public class Resume {
    private String name;
    private String email;
    private String phoneNumber;
    private final List<String> skills;
    private final List<Education> educationList;
    private final List<Experience> experienceList;

    public Resume() {
        this.skills = new ArrayList<>();
        this.educationList = new ArrayList<>();
        this.experienceList = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public void addEducation(Education education) {
        this.educationList.add(education);
    }

    public void addExperience(Experience experience) {
        this.experienceList.add(experience);
    }

    public void display() {
        System.out.println("\n--- Current Resume ---");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);

        System.out.println("\nSkills:");
        if (skills.isEmpty()) {
            System.out.println("  No skills added yet.");
        } else {
            skills.forEach(skill -> System.out.println("  - " + skill));
        }

        System.out.println("\nEducation:");
        if (educationList.isEmpty()) {
            System.out.println("  No education added yet.");
        } else {
            educationList.forEach(edu -> System.out.println(
                    "  - " + edu.getDegree() + " from " + edu.getSchoolName() + " (" + edu.getYearGraduated() + ")"));
        }

        System.out.println("\nWork Experience:");
        if (experienceList.isEmpty()) {
            System.out.println("  No experience added yet.");
        } else {
            experienceList.forEach(exp -> {
                System.out.println(
                        "  - " + exp.getRole() + " at " + exp.getCompanyName() + " (" + exp.getDuration() + ")");
                // Assuming getAchievements returns a List<String>
                List<String> achievements = (List<String>) exp.getAchievements();
                achievements.forEach(achievement -> System.out.println("    * " + achievement));
            });
        }
        System.out.println("----------------------");
    }
}
