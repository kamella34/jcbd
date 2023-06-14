package fr.diginamic.jdbc.jdbc.entites;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.dao.IFournisseurDao;

import java.util.List;

public class TestJdbcDao {

    public static void main(String[] args) {
        listFournisseurs();
        majFournisseur("FDM SA", "La Maison de la Chaussure");
        //Fournisseur f = new Fournisseur("La Maison de la Voiture");
        //deleteFournisseur(f);
        Fournisseur g = new Fournisseur("La Maison de la Chaussure");
        insertFournisseur(g);
    }

    public static void listFournisseurs() {
        try {
            IFournisseurDao dao = new FournisseurDaoJdbc();
            List<Fournisseur> fournisseurs = dao.extraire();
            for (Fournisseur fournisseur : fournisseurs) {
                System.out.println(fournisseur);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void majFournisseur(String ancienNom, String nouveauNom) {
        try {
            IFournisseurDao dao = new FournisseurDaoJdbc();
            System.out.println(dao.update(ancienNom, nouveauNom));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void deleteFournisseur(Fournisseur fournisseur) {
        try {
            IFournisseurDao dao = new FournisseurDaoJdbc();
            System.out.println(dao.delete(fournisseur));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void insertFournisseur(Fournisseur fournisseur) {
        try {
            IFournisseurDao dao = new FournisseurDaoJdbc();
            dao.insert(fournisseur);

        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
    }

}



