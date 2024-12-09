package Projects.Student;
import java.io.*;
import java.util.*;

public class StudentGrades {
    private ArrayList<Student> students = new ArrayList<>();

    public void read(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
          
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
    
            String lastName = parts[0];
            String firstName = parts[1];
            String ssn = parts[2];
            int year = Integer.parseInt(parts[3]);
            String courseName = parts[4];
            double numericGrade = Double.parseDouble(parts[5]);
            // if student alr there, no need to create new.
            Student student = findOrCreate(lastName, firstName, ssn, year); 
            student.addCourse(courseName, numericGrade);
        }
    
        reader.close();
    }
    
    
    

    private Student findOrCreate(String lastName, String firstName, String ssn, int year) {
        // find by ssn
        boolean found = false;
        for (Student student : students) {
            if (student.getSsn().equals(ssn)) {
                found = true;
                return student;
            }
        }
        if(!found) {
            Student newKid = new Student(lastName, firstName, ssn, year);
            students.add(newKid);
            return newKid;
        }
        return null;
    }

    public void statistics() {
        int numStudents = students.size();
        double totalGradeSum = 0;
        int totalAssignments = 0;
        int failing = 0;
        Map<Integer, List<Double>> yearGrades = new HashMap<>();
    
        for (Student student : students) {
            List<Course> courses = student.getCourses(); 
            for (Course course : courses) {
                totalGradeSum += course.getGrade(); 
                totalAssignments++;
            }
    
            double studentAvg = student.getNumericGrade();
            if (studentAvg < 60) {
                failing++;
            }
    
            int year = student.getYear();
            yearGrades.putIfAbsent(year, new ArrayList<>());
            yearGrades.get(year).add(studentAvg);
        }
    
        double avg = totalAssignments > 0 ? totalGradeSum / totalAssignments : 0;
    
        System.out.println("Overall Number of Students: " + numStudents);
        System.out.println("Average Numeric Grade: " + avg);
        System.out.println("Number of Failing Students: " + failing);
    
        for (int year : yearGrades.keySet()) {
            List<Double> grades = yearGrades.get(year);
            double yearSum = 0;
            for (double grade : grades) {
                yearSum += grade;
            }
            double yearAvg = grades.size() > 0 ? yearSum / grades.size() : 0;
            System.out.println("Year " + year + " Average Grade: " + yearAvg);
        }
    }       

    public static void main(String[] args) throws IOException {
        StudentGrades sg = new StudentGrades();
        sg.read("Student/students.txt");
        sg.statistics();
    }
}
