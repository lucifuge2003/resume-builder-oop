public class Education {
    private String schoolName;
    private String degree;
    private int yearGraduated;

    public Education(String schoolName, String degree, int year) {
        this.schoolName = schoolName;
        this.degree = degree;
        this.yearGraduated = year;
    }

    String getDegree() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    String getSchoolName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    String getYearGraduated() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
