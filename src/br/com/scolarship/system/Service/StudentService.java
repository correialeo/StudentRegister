package br.com.scolarship.system.Service;

import br.com.scolarship.system.DAO.StudentDAO;
import br.com.scolarship.system.model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentService {
    private Scanner rgst;
    private StudentDAO studentDAO;

    public StudentService(Scanner rgst,StudentDAO studentDAO) {
        this.rgst = rgst;
        this.studentDAO = studentDAO;
    }

    public String registerStudent(){
        String name;
        System.out.println("Whats name for this student?");
        name = rgst.nextLine();
        String rm;
        System.out.println("Whats the RM for " + name + "?");
        rm = rgst.nextLine();
        String course;
        System.out.println("What is the course with this student make?");
        course = rgst.nextLine();
        studentDAO.include(new Student(name, rm, course));
        return "Sucessfuly!";
    }

    public void showListOfStudents(){
        List<Student> studentQueVeio = studentDAO.showAll();
        studentQueVeio.forEach(x -> System.out.println(x.getName()+ " "+ x.getRm() + " "+ x.getCourse()));
    }

    public String removeStudent(){
        String removeRm;
        System.out.println("What is the RM of the student with you want to remove?");
        removeRm = rgst.nextLine();
        showListOfStudents();
        studentDAO.remove(removeRm);
        if (removeRm.isBlank()){
            throw new ValidationException("Name not found");
        }
        return "Sucessfuly!";
    }

    public String changeStudent(){
        String rm;
        System.out.println("Whats the RM of the student with you want to change?");
        rm = rgst.nextLine();
        String newName;
        System.out.println("Whats the new name?");
        newName = rgst.nextLine();
        showListOfStudents();
        studentDAO.change(rm,newName);
        return "Sucessfuly!";
    }

    public String changeRmStudent(){
        String oldRm;
        System.out.println("Whats the RM do you want to change?");
        oldRm = rgst.nextLine();
        String newRm;
        System.out.println("Whats the new RM?");
        newRm = rgst.nextLine();
        studentDAO.changeRm(oldRm, newRm);

//        showListOfStudents();
        return "Sucessfuly!";
    }
}
