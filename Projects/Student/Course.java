package Projects.Student;
public class Course {
    private String name;
    private double grade;

    public Course(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }
}
