package fr.diginamic.jdbc.jdbc.entites;

public class Article {
    private int id;
    private  String ref;
    private String designation;
    private double prix;

    private Fournisseur leFournisseur;

    public Article(int id, String ref, String designation, double prix, Fournisseur leFournisseur) {
        this.id = id;
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
        this.leFournisseur = leFournisseur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Fournisseur getLeFournisseur() {
        return leFournisseur;
    }

    public void setLeFournisseur(Fournisseur leFournisseur) {
        this.leFournisseur = leFournisseur;
    }
}
