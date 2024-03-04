package main;

import java.util.Scanner;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Tervetuloa Gifu-järjestelmään");
        System.out.println("Mille yliopistolle haluat ottaa järjestelmän käyttöön?");
        String university = sc.nextLine();
        Gifu gifu = new Gifu(university);

        boolean exit = false;
        while (!exit) {
            System.out.println("1) Luo uusi kurssi, 2) Luo uusi opiskelija, 3) Listaa kurssit, 4) Listaa opiskelijat, 5) Lisää opiskelija kurssille, 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, 8) Listaa opiskelijan arvosanat, 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");
            if (sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        System.out.println("Anna kurssin nimi:");
                        String courseName = sc.nextLine();
                        System.out.println("Anna kurssin ID:");
                        String courseID = sc.nextLine();
                        System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                        int maxStudents = Integer.parseInt(sc.nextLine());
                        Course course = new Course(maxStudents, courseName, courseID);
                        gifu.addCourse(course);
                        break;
                    case 2:
                        System.out.println("Anna opiskelijan nimi:");
                        String studentName = sc.nextLine();
                        System.out.println("Anna opiskelijan opiskelijanumero:");
                        String studentID = sc.nextLine();
                        Student student = new Student(studentName, studentID);
                        gifu.addStudent(student);
                        break;
                    case 3:
                        gifu.listCourses();
                        break;
                    case 4:
                        gifu.listStudents();
                        break;
                    case 5:
                        gifu.listCourses();
                        System.out.println("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
                        int courseChoice = Integer.parseInt(sc.nextLine());
                        Course chosenCourse = gifu.getCourses().get(courseChoice);
                        gifu.listStudents();
                        System.out.println("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero:");
                        int studentChoice = Integer.parseInt(sc.nextLine());
                        Student chosenStudent = gifu.getStudents().get(studentChoice);
                        gifu.enrollStudent(chosenStudent, chosenCourse);
                        break;
                    case 6:
                        gifu.listCourses();
                        System.out.println("Minkä kurssin haluat arvostella? Syötä kurssin numero: ");
                        courseChoice = Integer.parseInt(sc.nextLine());
                        chosenCourse = gifu.getCourses().get(courseChoice);
                        ArrayList<Enrollment> courseEnrollments = gifu.getEnrollments(chosenCourse);
                        for (Enrollment enrollment : courseEnrollments) {
                            System.out.println("Anna arvosana opiskelijalle " + enrollment.getStudent().getInformation());
                            int grade = Integer.parseInt(sc.nextLine());
                            enrollment.gradeCourse(grade);
                        }
                        break;
                    case 7:
                        gifu.listCourses();
                        System.out.println("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
                        courseChoice = Integer.parseInt(sc.nextLine());
                        chosenCourse = gifu.getCourses().get(courseChoice);
                        ArrayList<Enrollment> enrolledStudents = gifu.getEnrollments(chosenCourse);
                        for (Enrollment enrollment : enrolledStudents) {
                            System.out.println(enrollment.getStudent().getInformation() + ", arvosana: " + enrollment.getGrade());
                        }
                        break;
                    case 8:
                        gifu.listStudents();
                        System.out.println("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero:");
                        studentChoice = Integer.parseInt(sc.nextLine());
                        chosenStudent = gifu.getStudents().get(studentChoice);
                        System.out.println("Opiskelijan " + chosenStudent.getInformation() + " arvosanat:");
                        ArrayList<Enrollment> studentEnrollments = gifu.getEnrollments(chosenStudent);
                        for (Enrollment enrollment : studentEnrollments) {
                            System.out.println(enrollment.getCourse().getInformation() + ", arvosana: " + enrollment.getGrade());
                        }
                        break;
                    case 9:
                        for (Course c : gifu.getCourses()) {
                            System.out.println(c.getInformation());
                            ArrayList<Enrollment> courseGrades = gifu.getEnrollments(c);
                            for (Enrollment e : courseGrades) {
                                System.out.println(e.getStudent().getInformation() + ", arvosana: " + e.getGrade());
                            }
                        }
                        break;
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                }
            }
        }
        sc.close();
    }
}
