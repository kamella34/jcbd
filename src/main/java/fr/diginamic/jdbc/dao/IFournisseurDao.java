package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.jdbc.entites.Fournisseur;

import java.util.List;

public interface IFournisseurDao {
    List<Fournisseur> extraire() throws Exception;

    void insert(Fournisseur fournisseur) throws Exception;
    int update(String ancienNom, String nouveauNom) throws Exception;
    boolean delete(Fournisseur fournisseur) throws Exception;
    }


