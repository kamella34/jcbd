package fr.diginamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnectionJdbc {

    private static final String LOGIN = "root";
    private static final String MDP = "";

   private static final String URL = "jdbc:mysql://localhost:3306/compta";
    public static void main(String[] args) {


        try(Connection connection = DriverManager.getConnection(URL, LOGIN, MDP)) {
            System.out.println(connection);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
