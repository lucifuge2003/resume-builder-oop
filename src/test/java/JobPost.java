import java.util.List;

public class JobPost {
    private String jobTitle;
    private List<String> requirements;
    private String description;

    public JobPost(String jobTitle, List<String> requirements, String string) {
        this.jobTitle = jobTitle;
        this.requirements = requirements;
        this.description = string;
    }
}
