package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.jdbc.entites.Article;
import fr.diginamic.jdbc.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ResourceBundle;

public class ArticleDaoJdbc implements IArticleDao{

    private static final String INSERT_REQ = "INSERT INTO FOURNISSEUR (NOM) VALUES (?)";
    private static final String UPDATE_REQ_ALLQUERY = "UPDATE ARTICLE SET REF=?, DESIGNATION=?, PRIX=?,ID_FOU=?, WHERE ID=?";
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
    public List<Article> extraire() throws Exception {
        return null;
    }

    @Override
    public void insert(Article article) throws Exception {

    }


    @Override
    public int update(Article article) throws Exception {
        int nb = 0;

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, MDP);
             PreparedStatement ps= connection.prepareStatement(UPDATE_REQ_ALLQUERY);
        ) {
            ps.setString(1 , article.getRef());
            ps.setString(2 , article.getDesignation() );
            ps.setDouble(3 , article.getPrix());
            ps.setInt(4 , article.getLeFournisseur().getId());
            ps.setInt(5 , article.getId());
            ps.executeUpdate();
            System.out.println(nb);
        }
        return 0;
    }

    @Override
    public boolean delete(Article article) throws Exception {
        return false;
    }
}
