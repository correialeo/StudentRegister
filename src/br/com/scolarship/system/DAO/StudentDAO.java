package br.com.scolarship.system.DAO;

import br.com.scolarship.system.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentDAO {

    ConnectionDAO connectionDAO = new ConnectionDAO();

    public StudentDAO() {
    }

    public String include(Student student){
        try{
            PreparedStatement statement = connectionDAO.getConnection().prepareStatement("INSERT INTO TAB_STUDENTS (NAME, RM, COURSE) VALUES (?,?,?)");
            statement.setString(1,student.getName());
            statement.setString(2, student.getRm());
            statement.setString(3, student.getCourse());
            statement.execute();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return "Sucessfuly";
    }

    public String remove (String rm) {
        try{
            PreparedStatement statement = connectionDAO.getConnection().prepareStatement("DELETE FROM TAB_STUDENTS WHERE RM = ?");
            statement.setString(1, rm);
            statement.execute();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return "Sucessfuly!";
    }

    public String change (String rm, String newName){
        try{
            PreparedStatement statement = connectionDAO.getConnection().prepareStatement("UPDATE TAB_STUDENTS SET NAME = ? WHERE RM = ?");  //"UPDATE T_PRODUTO SET VL_PRODUTO = ? WHERE CD_PRODUTO = ?"
            statement.setString(1, newName);
            statement.setString(2, rm);
            statement.execute();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return "Sucessfuly!";
    }

    public String changeRm (String oldRm, String newRm) {
        try{
            PreparedStatement statement = connectionDAO.getConnection().prepareStatement("UPDATE TAB_STUDENTS SET RM = ? WHERE RM = ?");
            statement.setString(1, newRm);
            statement.setString(2, oldRm);
            statement.execute();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return "Sucessfuly!";
    }

    public List<Student> showAll ()  {
        List<Student> finalList = new ArrayList<>(); //chamou a lista pra retornar a lista *
        try{
            PreparedStatement statement = connectionDAO.getConnection().prepareStatement("SELECT * FROM TAB_STUDENTS");

            ResultSet resultQuery = statement.executeQuery();           //resultset -> o que vem da query ^  / executeQuery pq retorna o resultSet

            while (resultQuery.next()){                                 //quando acabar os estudantes ele finaliza e mostra a lista

                String nameQuery = resultQuery.getString("NAME");
                String rmQuery = resultQuery.getString("RM");
                String courseQuery = resultQuery.getString("COURSE");
                finalList.add(new Student(nameQuery, rmQuery, courseQuery));
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        //Ordena a lista alfabeticamente pelo nome
        Collections.sort(finalList, Comparator.comparing(Student::getRm));

        return finalList; // *
    }

}
