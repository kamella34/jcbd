package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {
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

        creerFournisseur();
        deleteFournisseur();

}

    private static void creerFournisseur() {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, MDP); Statement statement = connection.createStatement()) {
            int nb = statement.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('La Maison de la Peinture')");
            System.out.println(nb);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    private static void deleteFournisseur() {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, MDP); Statement statement = connection.createStatement()) {
            int nb = statement.executeUpdate("DELETE FOURNISSEUR WHERE NOM ='La Maison de la Peinture'");
            System.out.println(nb);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
