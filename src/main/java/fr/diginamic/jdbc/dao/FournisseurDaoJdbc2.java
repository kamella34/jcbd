package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc2 implements IFournisseurDao2 {

    private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE NOM =?";
    private static final String LOGIN;
    private static final String MDP;
    private static final String URL;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        URL = bundle.getString("db.url");
        LOGIN = bundle.getString("db.user");
        MDP = bundle.getString("db.mdp");
    }

    @Override
    public List<Fournisseur> extraire() {
        List<Fournisseur> resultatFournisseur = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, MDP);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM FOURNISSEUR")) {
            while (resultSet.next()) {
                resultatFournisseur.add(new Fournisseur(resultSet.getInt(1), resultSet.getString("NOM")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return resultatFournisseur;
    }


    @Override
    public void insert(Fournisseur fournisseur) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, MDP); Statement statement = connection.createStatement()) {
            int nb = statement.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES (fournisseur.getNom())");
            System.out.println(nb);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) {
        int nb = 0;
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, MDP); Statement statement = connection.createStatement()) {
            nb = statement.executeUpdate("UPDATE FOURNISSEUR SET NOM='" + nouveauNom + "' WHERE NOM='" + ancienNom + "'");
            System.out.println(nb);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean delete(Fournisseur fournisseur) {
        int nb = 0;
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, MDP);
             PreparedStatement deleteFournisseur = connection.prepareStatement(DELETE_QUERY)) {
            deleteFournisseur.setString(1, fournisseur.getNom());
            nb = deleteFournisseur.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return nb > 0;

    }
}
