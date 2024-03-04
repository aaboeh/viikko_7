package main;

public class Course implements PrintInfo {
    int maxNumberOfStudents;
    String name;
    String id;

    public Course(int maxNumberOfStudents, String name, String id) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.name = name;
        this.id = id;
    }

    @Override
    public String getInformation() {
        return id + " " + name;
    }
}