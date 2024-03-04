package main;

public class Enrollment {
    Student student;
    Course course;
    int grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.grade = -1;
    }

    public void gradeCourse(int grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }
 
}
