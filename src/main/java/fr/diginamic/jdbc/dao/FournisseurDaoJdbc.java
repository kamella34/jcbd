package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc implements IFournisseurDao {
    private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE NOM =?";
    private static final String EXTRAIRE_REQ = "SELECT * FROM FOURNISSEUR";
    private static final String UPDATE_REQ = "UPDATE FOURNISSEUR SET NOM = ? WHERE NOM = ?";

    private static final String INSERT_REQ = "INSERT INTO FOURNISSEUR (NOM) VALUES (?)";
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
    public List<Fournisseur> extraire() throws  SQLException {
        List<Fournisseur> resultatFournisseur = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, MDP);
             PreparedStatement ps= connection.prepareStatement(EXTRAIRE_REQ);
             ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                resultatFournisseur.add(new Fournisseur(resultSet.getInt(1), resultSet.getString("NOM")));
            }
        }
        return resultatFournisseur;

    }


    @Override
    public void insert(Fournisseur fournisseur) throws SQLException{
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, MDP);
             PreparedStatement ps = connection.prepareStatement(INSERT_REQ)) {
            ps.setString(1 , fournisseur.getNom());
            int nb = ps.executeUpdate();
            System.out.println(nb);
        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) throws SQLException {
        int nb = 0;

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, MDP);
             PreparedStatement ps= connection.prepareStatement(UPDATE_REQ);
             ) {
            ps.setString(1 , nouveauNom);
            ps.setString(2 , ancienNom);
            ps.executeUpdate();
            System.out.println(nb);
        }
        return 0;
    }
    @Override
    public boolean delete(Fournisseur fournisseur) throws SQLException{
        int nb = 0;
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, MDP);
             PreparedStatement deleteFournisseur = connection.prepareStatement(DELETE_QUERY)) {
            deleteFournisseur.setString(1, fournisseur.getNom());
            nb = deleteFournisseur.executeUpdate();
        }
        return nb>0;
    }






}
