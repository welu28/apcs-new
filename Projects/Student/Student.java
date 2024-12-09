package Student;
import java.util.*;
import Student.Course;

public class Student {
    private String lastName;
    private String firstName;
    private String ssn;
    private int year;
    private ArrayList<Course> courses;

    public Student(String lastName, String firstName, String ssn, int year) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.ssn = ssn;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    public void addCourse(String courseName, double numericGrade) {
        this.courses.add(new Course(courseName, numericGrade));
    }

    public double getNumericGrade() {
        double total = 0;
        for (Course course : courses) {
            total += course.getGrade();
        }
        return total / courses.size();
    }

    public String getLetterGrade() {
        double avg = getNumericGrade();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSsn() {
        return ssn;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
