package fr.diginamic.jdbc.jdbc.entites;


import fr.diginamic.jdbc.dao.FournisseurDaoJdbc2;

import fr.diginamic.jdbc.dao.IFournisseurDao;
import fr.diginamic.jdbc.dao.IFournisseurDao2;

import java.util.List;

public class TestJdbcDao2 {
    public static void main(String[] args) {
        listFournisseurs();
    }
    public static void listFournisseurs() {
        IFournisseurDao2 dao = new FournisseurDaoJdbc2();
        List<Fournisseur> fournisseurs = dao.extraire();
        for(Fournisseur fournisseur :fournisseurs){
            System.out.println(fournisseur);
        }
    }

}
