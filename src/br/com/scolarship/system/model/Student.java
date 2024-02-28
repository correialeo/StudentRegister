package br.com.scolarship.system.model;

public class Student {

    String name, rm, course;

    public Student(String name, String rm, String course) {
        this.name = name;
        this.rm = rm;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
