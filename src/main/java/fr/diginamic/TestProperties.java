package fr.diginamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestProperties {
    private static final String LOGIN;
    private static final String MDP;
    private static final String URL;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        URL = bundle.getString("db.url");
        LOGIN = bundle.getString("db.user");
        MDP = bundle.getString("db.mdp");
    }


    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, MDP)) {
            System.out.println(connection);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}