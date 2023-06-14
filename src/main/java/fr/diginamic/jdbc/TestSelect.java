package fr.diginamic.jdbc;

import fr.diginamic.jdbc.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestSelect {

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
        listFournisseur2();
    }

  private static void listeFournisseurs() {

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, MDP);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM FOURNISSEUR")) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) +". "+ resultSet.getString("NOM"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
private static void listFournisseur2(){
    try(
            Connection connection = DriverManager.getConnection(URL, LOGIN, MDP);
            Statement statement = connection.createStatement();
            ResultSet curseur = statement.executeQuery("SELECT ID, NOM FROM FOURNISSEUR"))

    {

        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();

        while (curseur.next()) {
            Integer id = curseur.getInt("ID");
            String nom = curseur.getString("NOM");
            Fournisseur fournisseurCourant = new Fournisseur(id, nom);
            fournisseurs.add(fournisseurCourant);
        }
        for (Fournisseur fournisseur : fournisseurs){
             System.out.println(fournisseur);
        }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}


