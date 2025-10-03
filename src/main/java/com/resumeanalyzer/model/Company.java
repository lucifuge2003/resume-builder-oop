import java.util.List;

public class Company {
    private String companyName;
    private List<JobPost> jobPosts;

    public void addJobPost(JobPost job) {
        jobPosts.add(job);
    }
}
