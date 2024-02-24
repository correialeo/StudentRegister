package br.com.scolarship.system.View;

import br.com.scolarship.system.Service.ValidationException;
import br.com.scolarship.system.DAO.StudentDAO;
import br.com.scolarship.system.Service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentService studentService = new StudentService(new Scanner(System.in), new StudentDAO());

        Scanner resposta = new Scanner(System.in);
       boolean finish = false;

       do {
           System.out.println("""
                   Enter 1 for register student
                   Enter 2 for remove student
                   Enter 3 for change name of student
                   Enter 4 for change RM student
                   Enter 5 for show all students
                   Enter 6 for finish system
                   """);
           switch (resposta.next()){
               case "1": studentService.registerStudent();
               break;

               case "2":
                   try{
                       studentService.removeStudent();
                   }catch (ValidationException ex) {
                       System.out.println(ex.getMessage());
                   }
               break;

               case "3": studentService.changeStudent();
               break;

               case "4": studentService.changeRmStudent();
               break;

               case "5": studentService.showListOfStudents();
               break;

               case "6": finish = true;
               break;
           }
       } while (!finish);
    }
}