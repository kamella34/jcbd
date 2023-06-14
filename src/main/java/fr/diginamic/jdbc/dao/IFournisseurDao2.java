package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.jdbc.entites.Fournisseur;

import java.util.List;

public interface IFournisseurDao2 {

        List<Fournisseur> extraire() ;

        void insert(Fournisseur fournisseur);
        int update(String ancienNom, String nouveauNom);
        boolean delete(Fournisseur fournisseur) ;


}
