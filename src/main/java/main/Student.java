package main;

public class Student implements PrintInfo {
    String name;
    String id;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getInformation() {
        return id + " " + name;
    }
}
