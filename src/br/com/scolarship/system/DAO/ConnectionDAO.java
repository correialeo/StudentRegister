package br.com.scolarship.system.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
    Connection connection;
    {

    }
    public ConnectionDAO()  {
        try{
            connection=  DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RMXXXXXX", "XXXXXX");
        }catch (SQLException ex){
            System.out.println("ERRO NO BD");
        }
    }
    public void closeConnection() {
        try{
        connection.close();
        }catch (SQLException ex){
        System.out.println(ex.getMessage());
        }
    }
    public Connection getConnection() {
        try{
        if (connection == null){
            connection=  DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RMXXXXXX", "XXXXXX");
        }
        }catch (SQLException ex){
            System.out.println("ERRO NO BD");
        }
        return connection;
    }
}
