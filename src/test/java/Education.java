public class Education {
    private final String schoolName;
    private final String degree;
    private final int yearGraduated;

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
