import java.util.List;

public class Experience {
    private String companyName;
    private String role;
    private String duration;
    private List<String> achievements;

    public Experience(String companyName, String role, String duration, List<String> achievements) {
        this.companyName = companyName;
        this.role = role;
        this.duration = duration;
        this.achievements = achievements;
    }

    String getRole() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    String getCompanyName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    String getDuration() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Object getAchievements() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
