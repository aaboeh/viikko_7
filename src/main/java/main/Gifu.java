package main;

import java.util.ArrayList;

public class Gifu {
    String university;
    ArrayList<Course> courses;
    ArrayList<Student> students;
    ArrayList<Enrollment> enrollments;

    public Gifu (String university) {
        this.university = university;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.enrollments = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void enrollStudent(Student student, Course course) {
        Enrollment enrollment = new Enrollment(student, course);
        enrollments.add(enrollment);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void listCourses() {
        int i = 0;
        for (Course course : getCourses()) {
            System.out.println(i + ") " + course.getInformation());
            i++;
        }
    }

    public void listStudents() {
        int j = 0;
        for (Student student : getStudents()) {
            System.out.println(j + ") " + student.getInformation());
            j++;
        }
    }

    public ArrayList<Enrollment> getEnrollments(Course course) {
        ArrayList<Enrollment> results = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse().equals(course)) {
                results.add(enrollment);
            }
        }
        return results;
    }

    public ArrayList<Enrollment> getEnrollments (Student student) {
        ArrayList<Enrollment> results = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().equals(student)) {
                results.add(enrollment);
            }
        }
        return results;
    }

}
